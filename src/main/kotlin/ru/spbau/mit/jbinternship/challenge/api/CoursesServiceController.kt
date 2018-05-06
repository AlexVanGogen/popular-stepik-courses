package ru.spbau.mit.jbinternship.challenge.api

import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.spbau.mit.jbinternship.challenge.entities.CoursesList
import ru.spbau.mit.jbinternship.challenge.entities.CoursesPageData

class CoursesServiceController {

    val BASE_URL = "https://stepik.org/"

    fun getAllCourses(): CoursesList {
        val retrofitExecutor: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
                .build()

        val coursesService: CoursesService = retrofitExecutor.create(CoursesService::class.java)

        val allCoursesList = CoursesList()

        var currentPageNumber = 1
        while (true) {
            val call: Call<CoursesPageData> = coursesService.getCoursesDataOnPage(pageNumber = currentPageNumber)
            val response: Response<CoursesPageData> = call.execute()
            if (response.isSuccessful) {
                val coursesDataOnPage: CoursesPageData? = response.body()
                allCoursesList.addAll(coursesDataOnPage!!.coursesOnPage)
                if (coursesDataOnPage.isOnLastPage()) {
                    break
                }
                currentPageNumber++
            } else {
                println(response.errorBody())
            }
        }

        return allCoursesList
    }
}