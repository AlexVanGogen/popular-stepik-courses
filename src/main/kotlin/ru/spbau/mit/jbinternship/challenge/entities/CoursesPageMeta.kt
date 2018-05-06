package ru.spbau.mit.jbinternship.challenge.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CoursesPageMeta(@JsonProperty("has_next") val isNextPageExist: Boolean)