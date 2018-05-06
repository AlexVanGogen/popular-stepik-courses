package ru.spbau.mit.jbinternship.challenge.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Course(@JsonProperty("title") val title: String,
                  @JsonProperty("summary") val summary: String,
                  @JsonProperty("workload") val workload: String,
                  @JsonProperty("create_date") val beginDate: String,
                  @JsonProperty("authors") val courseAuthorsIds: List<Int>,
                  @JsonProperty("learners_count") val learnersCount: Int) {

    private val authors: MutableList<Author> = mutableListOf()

    fun addAuthor(author: Author) = authors.add(author)
    fun getAuthors() = authors
}