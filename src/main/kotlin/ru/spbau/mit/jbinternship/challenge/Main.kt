package ru.spbau.mit.jbinternship.challenge

import ru.spbau.mit.jbinternship.challenge.requests.*

fun main(args: Array<String>) {
    println("How many popular courses do you want to see?")
    val answer = readLine()?.toLongOrNull()
    if (answer == null || answer < 0) {
        println("Error: single non-negative number expected")
    } else {
        when (answer) {
            0.toLong() -> println("Nothing to print")
            else -> {
                getNMostPopularCoursesOnStepik(answer)
            }
        }
    }
    System.exit(0)
}