package com.j0t1m4.teensecure.data.contents

data class CourseContent(
    val levelTitle: String, val introduction: String, val description: String, val learningContents: List<LearningContent>, val tips: String
)

data class LearningContent(
    val title: String, val content: String
)