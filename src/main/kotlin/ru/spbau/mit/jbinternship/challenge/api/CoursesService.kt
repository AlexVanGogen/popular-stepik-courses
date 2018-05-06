package ru.spbau.mit.jbinternship.challenge.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.spbau.mit.jbinternship.challenge.entities.CoursesPageData

interface CoursesService {
    @GET("api/courses") fun getCoursesDataOnPage(@Query("page") pageNumber: Int): Call<CoursesPageData>
}