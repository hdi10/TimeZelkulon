package de.zelkulon.timezelkulon.instances

import de.zelkulon.timezelkulon.api.BlogApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "https://apigateway-myproject-1b6db96b72fe.herokuapp.com"

    val api: BlogApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlogApiService::class.java)
    }
}