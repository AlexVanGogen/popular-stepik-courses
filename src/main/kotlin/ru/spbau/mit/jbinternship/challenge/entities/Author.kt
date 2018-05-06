package ru.spbau.mit.jbinternship.challenge.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Author(@JsonProperty("full_name") val fullName: String,
                  @JsonProperty("details") val details: String)