package ru.spbau.mit.jbinternship.challenge.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.spbau.mit.jbinternship.challenge.entities.AuthorPageData

interface AuthorService {
    @GET("api/users/{id}") fun getAuthorById(@Path("id") authorId: Int): Call<AuthorPageData>
}