package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.contents.CourseContent
import com.j0t1m4.teensecure.data.contents.RansomWranglerCourse
import com.j0t1m4.teensecure.databinding.FragmentSelectLevelBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSelectLevel : Fragment() {
    private lateinit var binding: FragmentSelectLevelBinding
    private var selectedLevel: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnBeginnerDefault.setOnClickListener {
            handleLevelSelection("beginner")
        }

        binding.btnIntermediateDefault.setOnClickListener {
            handleLevelSelection("intermediate")
        }

        binding.btnProfessionalDefault.setOnClickListener {
            handleLevelSelection("professional")
        }

        binding.btnProceed.setOnClickListener {
            if (selectedLevel == null) {
                Toast.makeText(context, "Please select a level", Toast.LENGTH_SHORT).show()
            } else {
                navigateToNextFragment(selectedLevel!!)
            }
        }
    }

    private fun handleLevelSelection(level: String) {
        selectedLevel = level

        when (level) {
            "beginner" -> binding.imgSelectedLevel.setImageResource(R.drawable.beginner_selected)
            "intermediate" -> binding.imgSelectedLevel.setImageResource(R.drawable.intermediate_selected)
            "professional" -> binding.imgSelectedLevel.setImageResource(R.drawable.professional_selected)
        }

        binding.imgSelectedLevel.visibility = View.VISIBLE

        // Hide all buttons
        binding.btnBeginnerDefault.visibility = View.GONE
        binding.btnIntermediateDefault.visibility = View.GONE
        binding.btnProfessionalDefault.visibility = View.GONE
    }

    private fun navigateToNextFragment(level: String) {
        var content: CourseContent? = null
        when (level) {
            "beginner" -> content = RansomWranglerCourse().level1
            "intermediate" -> content = RansomWranglerCourse().level2
            "professional" -> content = RansomWranglerCourse().level3
        }
        // Navigate to the next fragment
        if (content != null) {
            FragmentSelectLevelDirections.actionFragmentSelectLevelToFragmentLearningContent(content).apply {
                findNavController().navigate(this)
            }
        }
    }


}