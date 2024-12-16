package de.zelkulon.timezelkulon.instances

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.zelkulon.timezelkulon.api.BlogApiService
import de.zelkulon.timezelkulon.tool.DateDeserializer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date


object RetrofitInstance {
    private const val BASE_URL = "https://zelkulonmicroservice-myproject-1df345e27274.herokuapp.com"

    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(Date::class.java, DateDeserializer())
        .create()

    val api: BlogApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(BlogApiService::class.java)
    }
}