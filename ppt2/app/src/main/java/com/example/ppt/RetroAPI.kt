package com.example.ppt

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetroAPI {
    @POST("models/text-bison-001:generateText")
    fun generateText(
        @Header("Authorization") apiKey: String,
        @Body requestData: Prompt
    ): Call<PromptResponse>
}
