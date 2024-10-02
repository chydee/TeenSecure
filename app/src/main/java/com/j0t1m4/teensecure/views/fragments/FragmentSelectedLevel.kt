package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.contents.CourseContent
import com.j0t1m4.teensecure.data.contents.TeenSecureCourse
import com.j0t1m4.teensecure.databinding.FragmentSelectedLevelBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSelectedLevel : Fragment() {

    private lateinit var binding: FragmentSelectedLevelBinding
    private val args: FragmentSelectedLevelArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectedLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.white)
        // Assume 'selectedTopic' comes from arguments or user selection
        val selectedTopic = args.selectedTopic  // You will need to handle topic selection in your app
        handleLevelSelection(args.selectedLevel)
        binding.btnProceed.setOnClickListener {
            navigateToNextFragment(selectedTopic, args.selectedLevel)
        }
    }

    private fun handleLevelSelection(level: String) {
        when (level) {
            "beginner" -> binding.imgSelectedLevel.setImageResource(R.drawable.beginner_selected)
            "intermediate" -> binding.imgSelectedLevel.setImageResource(R.drawable.intermediate_selected)
            "professional" -> binding.imgSelectedLevel.setImageResource(R.drawable.professional_selected)
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
            FragmentSelectedLevelDirections.actionFragmentSelectedLevelToFragmentLearningContent(it, "Teen Secure", selectedLevel, topic).apply {
                findNavController().navigate(this)
            }
        }
    }
}