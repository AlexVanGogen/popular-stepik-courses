package ru.spbau.mit.jbinternship.challenge.entities

class CoursesList(): Iterable<Course> {

    private val coursesList: MutableList<Course> = ArrayList()

    constructor(courses: List<Course>) : this() {
        coursesList.addAll(courses)
    }

    fun add(course: Course) = coursesList.add(course)

    fun addAll(courses: Collection<Course>) {
        for (course in courses) {
            coursesList.add(course)
        }
    }

    override fun iterator() = coursesList.iterator()
    fun stream() = coursesList.stream()
}