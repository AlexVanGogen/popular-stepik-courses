package ru.spbau.mit.jbinternship.challenge.requests

import ru.spbau.mit.jbinternship.challenge.api.AuthorServiceController
import ru.spbau.mit.jbinternship.challenge.api.CoursesServiceController
import ru.spbau.mit.jbinternship.challenge.entities.Author
import ru.spbau.mit.jbinternship.challenge.entities.CoursesList
import java.util.*
import kotlin.streams.toList
import java.text.SimpleDateFormat
import java.text.ParseException
import java.util.TimeZone

fun getNMostPopularCoursesOnStepik(n: Long) {
    println("Get $n most popular courses")
    println("Please wait, this request may take a long time... (approx. 4 minutes)")
    println()
    val controller = CoursesServiceController()
    val allCourses: CoursesList = controller.getAllCourses()

    val nMostPopularCourses = CoursesList(
            allCourses.stream()
                    .sorted(Comparator.comparingInt({ -it.learnersCount }))
                    .limit(n)
                    .toList()
    )

    val authorController = AuthorServiceController()
    for (nextCourse in nMostPopularCourses) {
        for (nextAuthorId in nextCourse.courseAuthorsIds) {
            val nextAuthorInfo: Author? = authorController.getAuthor(nextAuthorId)
            if (nextAuthorInfo != null) {
                nextCourse.addAuthor(nextAuthorInfo)
            }
        }
    }

    for (nextCourse in nMostPopularCourses) {
        val summaryWithoutUnnecessarySymbols = removeTagsAndLineSeparators(nextCourse.summary)
        println("Course title: ${nextCourse.title} (${nextCourse.learnersCount} students)")
        println("\tStart date: ${fromISO8601UTC(nextCourse.beginDate)}")
        print("\tSummary: ")
        println(summaryWithoutUnnecessarySymbols)
        println("\tWorkload: ${if (nextCourse.workload.isNotBlank()) nextCourse.workload else "undefined"}")
        println("\tAuthors:")
        for (nextAuthor in nextCourse.getAuthors()) {
            println("\t\t${nextAuthor.fullName}")
        }
        println()
    }
}

private fun fromISO8601UTC(dateStr: String): Date? {
    val tz = TimeZone.getTimeZone("UTC")
    val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    df.timeZone = tz

    try {
        return df.parse(dateStr)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return null
}

private fun removeTagsAndLineSeparators(s: String): String {
    return s.replace(Regex("\r|\n|<.*?>"), "")
}