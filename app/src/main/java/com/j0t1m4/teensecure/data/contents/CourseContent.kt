package com.j0t1m4.teensecure.data.contents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseContent(
    val levelTitle: String, val introduction: String, val description: String, val learningContents: List<LearningContent>, val tips: String, val quiz: List<Question>
) : Parcelable

@Parcelize
data class LearningContent(
    val title: String, val content: String
) : Parcelable