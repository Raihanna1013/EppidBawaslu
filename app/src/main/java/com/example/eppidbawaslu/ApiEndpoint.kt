package com.example.eppidbawaslu

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("data.php")
    fun data() : Call<NoteModel>

    @POST("create.php")
    fun createData(
        @Body body: RequestBody
    ) : Call<SubmitModel>
}