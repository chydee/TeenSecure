package com.j0t1m4.teensecure.views.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.j0t1m4.teensecure.data.contents.CourseContent
import com.j0t1m4.teensecure.data.contents.RansomWranglerCourse
import com.j0t1m4.teensecure.data.contents.TeenSecureCourse
import com.j0t1m4.teensecure.databinding.FragmentCourseCompletedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentCourseCompleted : Fragment() {
    private lateinit var binding: FragmentCourseCompletedBinding
    private val args by navArgs<FragmentCourseCompletedArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCourseCompletedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.courseTitle.text = args.courseTitle
        binding.btnContinue.setOnClickListener {
            if (args.game == "Teen Secure") {
                val selectedLevel = when (args.level) {
                    1 -> "beginner"
                    2 -> "intermediate"
                    3 -> "professional"
                    else -> "beginner"
                }
                navigateToNextFragment(args.courseTitle, selectedLevel)
            } else {
                navigateToRwCourseContent(args.level, args.courseTitle)
            }
        }
    }

    private fun navigateToNextFragment(topic: String, level: String) {

        var content: CourseContent? = null
        when (topic) {
            "phishing" -> {
                content = when (level) {
                    "beginner" -> TeenSecureCourse.phishingBeginner
                    "intermediate" -> TeenSecureCourse.phishingIntermediate
                    "professional" -> TeenSecureCourse.phishingAdvanced
                    else -> null
                }
            }

            "baiting" -> {
                content = when (level) {
                    "beginner" -> TeenSecureCourse.baitingBeginner
                    "intermediate" -> TeenSecureCourse.baitingIntermediate
                    "professional" -> TeenSecureCourse.baitingAdvanced
                    else -> null
                }
            }

            "impersonation" -> {
                content = when (level) {
                    "beginner" -> TeenSecureCourse.impersonationBeginner
                    "intermediate" -> TeenSecureCourse.impersonationIntermediate
                    "professional" -> TeenSecureCourse.impersonationAdvanced
                    else -> null
                }
            }

            "cyberbullying" -> {
                content = when (level) {
                    "beginner" -> TeenSecureCourse.cyberbullyingBeginner
                    "intermediate" -> TeenSecureCourse.cyberbullyingIntermediate
                    "professional" -> TeenSecureCourse.cyberbullyingAdvanced
                    else -> null
                }
            }
            // Add more topics as needed
            else -> content = null
        }
        val selectedLevel = when (level) {
            "beginner" -> 1
            "intermediate" -> 2
            "professional" -> 3
            else -> -1
        }
        // Navigate to the next fragment if content is not null
        content?.let {
            FragmentCourseCompletedDirections.actionFragmentCourseCompletedToFragmentLearningContent(it, "Teen Secure", selectedLevel, topic).apply {
                findNavController().navigate(this)
            }
        }
    }

    private fun navigateToRwCourseContent(level: Int, topic: String) {
        var content: CourseContent? = null
        when (level) {
            1 -> content = RansomWranglerCourse.level1Content
            2 -> content = RansomWranglerCourse.level2Content
            3 -> content = RansomWranglerCourse.level3Content
            4 -> content = RansomWranglerCourse.level4Content
            5 -> content = RansomWranglerCourse.level5Content
        }
        // Navigate to CourseContentFragment, passing the selected level
        val action = content?.let { FragmentCourseCompletedDirections.actionFragmentCourseCompletedToFragmentLearningContent(it, "Ransom Wrangler", level, topic) }
        if (action != null) {
            findNavController().navigate(action)
        }
    }
}