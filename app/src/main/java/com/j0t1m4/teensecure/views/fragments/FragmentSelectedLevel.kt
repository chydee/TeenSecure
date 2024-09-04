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
import com.j0t1m4.teensecure.data.contents.RansomWranglerCourse
import com.j0t1m4.teensecure.databinding.FragmentSelectedLevelBinding
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
        handleLevelSelection(args.selectedLevel)
        binding.btnProceed.setOnClickListener {
            navigateToNextFragment(args.selectedLevel)
        }
    }

    private fun handleLevelSelection(level: String) {
        when (level) {
            "beginner" -> binding.imgSelectedLevel.setImageResource(R.drawable.beginner_selected)
            "intermediate" -> binding.imgSelectedLevel.setImageResource(R.drawable.intermediate_selected)
            "professional" -> binding.imgSelectedLevel.setImageResource(R.drawable.professional_selected)
        }
    }

    private fun navigateToNextFragment(level: String) {
        var content: CourseContent? = null
        when (level) {
            "beginner" -> content = RansomWranglerCourse().level1Content
            "intermediate" -> content = RansomWranglerCourse().level2Content
            "professional" -> content = RansomWranglerCourse().level3Content
        }
        // Navigate to the next fragment
        if (content != null) {
            FragmentSelectedLevelDirections.actionFragmentSelectedLevelToFragmentLearningContent(content).apply {
                findNavController().navigate(this)
            }
        }
    }
}