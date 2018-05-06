package ru.spbau.mit.jbinternship.challenge.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class CoursesPageData(@JsonProperty("meta") val meta: CoursesPageMeta,
                      @JsonProperty("courses") val coursesOnPage: List<Course>)
    : Iterable<Course> {

    fun isOnLastPage() = !meta.isNextPageExist

    override fun iterator() = coursesOnPage.iterator()
}