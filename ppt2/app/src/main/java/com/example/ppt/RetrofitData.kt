package com.example.ppt

import android.content.Context

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.json.JSONObject;
import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.stream.Collectors
import javax.*


class RetrofitData {
}

private const val stringAPIKey = "AIzaSyBiEQPGIm-bguktppBkTL6OQvI8671gsiM"
private const val stringURLEndPoint =
    ("https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="
            + stringAPIKey)

fun main() {

//    val output = getDataFromPalmAPI("make a ppt on android development and give me 4 slides with slide no, title and content in json array")
//    println(output)
    var str = "rushikesh is good boy"
    val intRange = IntRange(2,2)
    str = str.removeRange(intRange)
    println(str)

//    val jsonParser =
//        JsonParser.parseReader(FileReader("C:\\Users\\SALUNRN\\Desktop\\Rushikesh\\AndroidStudioProjects\\ppt2\\app\\src\\main\\assets\\result.json"))
//    for (i in 0..jsonParser.asJsonArray.size() - 1) {
//        println("slide no:$i")
//        println(jsonParser.asJsonArray.get(i).asJsonObject.get("slide_no"))
//        println("Title")
//        val str = jsonParser.asJsonArray.get(i).asJsonObject.get("title").toString()
//
//        println(str.substring(1, str.length - 1))
//        // executeQuery(query = jsonParser.asJsonArray.get(i).asJsonObject.get("title").toString())
//        getImageFromQuery(str.substring(1, str.length - 1))
//        println("Content")
//        println(jsonParser.asJsonArray.get(i).asJsonObject.get("content"))
//        println()
//    }


}

fun getDataFromPalmAPI(query: String) {

    val jsonObject = JSONObject()
    val jsonObjectText = JSONObject()
    try {
        jsonObjectText.put("text", query);
        jsonObject.put("prompt", jsonObjectText);

    } catch (e : JSONException) {
        println(e.message)
    }
    val jsonObjectRequest = object : JsonObjectRequest(
        Method.POST,
        stringURLEndPoint,
        jsonObject,
        Response.Listener { response ->
            try {
                val stringOutput = response.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getString("output")
                println(stringOutput)
            } catch (e: JSONException) {
                println(e.message)
            }
        }, Response.ErrorListener {
            println(it)
        }) {

        override fun getHeaders(): Map<String, String> {
            val mapHeader: MutableMap<String, String> = HashMap()
            mapHeader["Content-Type"] = "application/json"
            return mapHeader
        }
    }


    val intTimeoutPeriod = 60000; //60 seconds
    val retryPolicy =  DefaultRetryPolicy(
        intTimeoutPeriod,
        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
    );

    jsonObjectRequest.retryPolicy = retryPolicy;
    val queue: RequestQueue = Volley.newRequestQueue(null)
    queue.add(jsonObjectRequest)

}

fun getImageFromQuery(query: String) :String{
    try {
        val url =
            URL(
                "https://www.googleapis.com/customsearch/v1?key=" + "AIzaSyBiEQPGIm-bguktppBkTL6OQvI8671gsiM" + "&cx=530511ee58e724937" + "&q=" + query.replace(
                    " ",
                    "+"
                )
            )
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader(InputStreamReader(connection.inputStream)).use { reader ->
                val response =
                    reader.lines().collect(Collectors.joining())
                val parser = JsonParser()
                val jsonReader = JsonReader(response.reader())
                val jsonArray: JsonArray =
                    parser.parse(jsonReader).getAsJsonObject().get("items") as JsonArray
                val result =
                    jsonArray.get(1).asJsonObject.get("pagemap").asJsonObject?.get("cse_image")?.asJsonArray?.get(
                        0
                    ).toString()
                if(result=="null"){
                    return jsonArray.get(1).asJsonObject.get("pagemap").asJsonObject?.get("metatags")?.asJsonArray?.get(
                        1
                    ).toString()
                }
                return result


            }

        } else {
            return connection.responseMessage

        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return "EMPTY"
}


//fun executeQuery(query: String) {
//    val encodeQuery = URLEncoder.encode(query, "UTF-8")
//    val document =
//        Jsoup.connect("https://www.google.co.in/search?biw=1366&bih=675&tbm=isch&sa=1&ei=qFSJWsuTNc-wzwKFrZHoCw&q=$encodeQuery")
//            .get()
//    val imgs = document.select("img")
//    for (image in imgs) {
//        val s = image.attr("src")
//        if (s.contains("encrypted")) {
//            println(s)
//            return
//        }
//
//    }
//}


//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://generativelanguage.googleapis.com/v1beta3/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiService = retrofit.create(RetroAPI::class.java)
//
//    val requestData = Prompt("android development")
//
//    val call = apiService.generateText("AIzaSyBmq372t0Og8IrAd7S6QC0c_evh9Fwy0HY",requestData)
//
//    call.enqueue(object : Callback<PromptResponse> {
//        override fun onResponse(call: Call<PromptResponse>, response: Response<PromptResponse>) {
//            if (response.isSuccessful) {
//                val promptResponse = response.body()
//                println(promptResponse)
//            } else {
//                 println(response.toString())
//
//            }
//             println(response.toString())
//        }
//
//        override fun onFailure(call: Call<PromptResponse>, t: Throwable) {
//            println(t.toString())
//
//        }
//    })
//
//}