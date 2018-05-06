package ru.spbau.mit.jbinternship.challenge.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class AuthorPageData(@JsonProperty("users") val authors: List<Author>)
    : Iterable<Author> {

    override fun iterator() = authors.iterator()
}