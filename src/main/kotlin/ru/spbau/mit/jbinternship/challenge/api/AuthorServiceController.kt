package ru.spbau.mit.jbinternship.challenge.api

import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.spbau.mit.jbinternship.challenge.entities.Author
import ru.spbau.mit.jbinternship.challenge.entities.AuthorPageData

class AuthorServiceController {

    val BASE_URL = "https://stepik.org/"

    fun getAuthor(authorId: Int): Author? {
        val retrofitExecutor: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
                .build()

        val courseAuthorService: AuthorService = retrofitExecutor.create(AuthorService::class.java)

        val call: Call<AuthorPageData> = courseAuthorService.getAuthorById(authorId)
        val response: Response<AuthorPageData> = call.execute()
        if (response.isSuccessful) {
            val authorData: AuthorPageData? = response.body()
            return authorData?.authors?.get(0)
        } else {
            println(response.errorBody())
            return null
        }
    }
}