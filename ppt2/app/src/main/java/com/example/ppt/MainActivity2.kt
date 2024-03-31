package com.example.ppt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import org.json.JSONException
import org.json.JSONObject


class MainActivity2 : AppCompatActivity() {
    private var textView: TextView? = null
    private var editText: EditText? = null
    private val stringAPIKey = "AIzaSyBiEQPGIm-bguktppBkTL6OQvI8671gsiM"
    private val stringURLEndPoint =
        ("https://generativelanguage.googleapis.com/v1beta2/models/text-bison-001:generateText?key="
                + stringAPIKey)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        editText = findViewById<EditText>(R.id.editTextText)
        textView = findViewById<TextView>(R.id.textView)
    }

    fun buttonPaLMAPI(view: View?) {
        var stringInputText =
            "make a ppt on android development with 5 slides with slide no, title, and content with 5 lines only. give me slide no , title and content in 3 different arrays"
        if (editText!!.text.toString().isNotEmpty()) {
            stringInputText =
                "make a ppt on ${editText!!.text} with 5 slides with slide no, title and content with 5 lines only. give me slide no , title and content in 3 different lists. Output should contain only list"

        }
        val jsonObject = JSONObject()
        val jsonObjectText = JSONObject()
        try {
            jsonObjectText.put("text", stringInputText)
            jsonObject.put("prompt", jsonObjectText)
        } catch (e: JSONException) {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_SHORT).show()
            throw RuntimeException(e)

        }
        val jsonObjectRequest: JsonObjectRequest = @SuppressLint("SuspiciousIndentation")
        object : JsonObjectRequest(Request.Method.POST,
            stringURLEndPoint,
            jsonObject,
            Response.Listener<JSONObject?> { response ->
                try {
                    var stringOutput = response.getJSONArray("candidates")
                        .getJSONObject(0)
                        .getString("output")
                    textView!!.text = stringOutput
                    stringOutput = stringOutput.replace("```json", "")
                    stringOutput = stringOutput.replace("```", "")
                    stringOutput = stringOutput.replace("\\\\", "")
                    //val jsonArray = JsonParser.parseString(stringOutput)


                    var count = 0
                    for (i in stringOutput.indices) {
                        if (i + 1 < stringOutput.length) {


                            val char = stringOutput[i] + "" + stringOutput[i + 1]

                            if (char == "\",") {
                                //Log.d("JSONCONTENT", char)

                                count++
                                if (count == 2) {
//                                    Log.d("JSONCONTENT", stringOutput[i].toString())
//                                    Log.d("JSONCONTENT","###########")
//                                    Log.d("JSONCONTENT", stringOutput[i + 1].toString())
                                    val intRange = IntRange(i + 1, i + 1)
                                    if (stringOutput[i].toString() == "\"" && stringOutput[i + 1].toString() == ",") {
                                        stringOutput = stringOutput.removeRange(intRange)
                                        //  Log.d("JSONCONTENT", stringOutput)
                                        count = 0

                                    }

                                }

                            }
                        }

                    }
                    Log.d("JSONCONTENT", stringOutput)
                    try {
                        val jsonArray = JsonParser.parseString(stringOutput)
                        Log.d("JSONCONTENT", jsonArray.toString())
                        for (i in 0 until jsonArray.asJsonArray.size()) {
                            val jsonObject = jsonArray.asJsonArray.get(i).asJsonObject
                            val slideNo = jsonObject["slideNo"].asInt
                            val title = jsonObject["title"].asString
                            val content = jsonObject["content"].asString

                            // Print slide number, title, and content
                            println("Slide No: $slideNo")
                            println("Title: $title")
                            println("Content: $content")
                            println()
                        }

                    } catch (e: JsonParseException) {

                        Log.d("JSONCONTENT", e.message.toString())

                    }
                    Toast.makeText(applicationContext, stringOutput, Toast.LENGTH_SHORT).show()
                } catch (e: JSONException) {
                    Toast.makeText(applicationContext, e.message, Toast.LENGTH_SHORT).show()
                    throw RuntimeException(e)
                }
            }, Response.ErrorListener { textView!!.text = "Error" }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val mapHeader: MutableMap<String, String> = HashMap()
                mapHeader["Content-Type"] = "application/json"
                return mapHeader
            }
        }
        val intTimeoutPeriod = 60000 //60 seconds
        val retryPolicy: RetryPolicy = DefaultRetryPolicy(
            intTimeoutPeriod,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        jsonObjectRequest.retryPolicy = retryPolicy
        Volley.newRequestQueue(applicationContext).add(jsonObjectRequest)
    }


}