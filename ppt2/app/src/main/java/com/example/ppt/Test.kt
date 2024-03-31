package com.example.ppt

import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors


fun main() {
//
//    val reader = File("C:\\Users\\SALUNRN\\Desktop\\Rushikesh\\AndroidStudioProjects\\ppt2\\app\\src\\main\\assets\\google.json")
//    val parser = JsonParser()
//    val jsonReader = JsonReader(reader.reader(Charsets.UTF_8))
//    val jsonArray: JsonArray =
//        parser.parse(jsonReader).getAsJsonObject().get("items") as JsonArray
//    println(jsonArray.get(1).asJsonObject.get("pagemap").asJsonObject.get("cse_image").asJsonArray.get(0).asJsonObject.get("src"))





//
//    val url = "https://www.android.com/"
//
//
//    try {
//        val document: Document = Jsoup.connect(url).get()
//
//        // Select all image elements on the page
//        val images: Elements = document.select("img")
//        for (image in images) {
//            // Get the source URL of each image
//            val imageUrl = image.absUrl("src")
//
//            // Download the image
//            downloadImage(imageUrl)
//        }
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
    getImageFrom("android development resources")

}

fun getImageFrom(query:String){
    try {
        val url =
            URL("https://www.googleapis.com/customsearch/v1?key=" + "AIzaSyBiEQPGIm-bguktppBkTL6OQvI8671gsiM" + "&cx=530511ee58e724937" + "&q=" + query.replace(" ","+"))
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
                for(i in 0..jsonArray.size()-1){
                    println(jsonArray.get(i).asJsonObject.get("pagemap").asJsonObject.get("cse_image").asJsonArray.get(0).asJsonObject.get("src"))

                }


            }

        } else {
            println("Error: ${connection.responseMessage}")
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
private fun downloadImage(imageUrl: String) {
    try {
        val url = URL(imageUrl)
        // You can customize the image name or save it to a specific directory
        println("Downloaded: $url")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}


