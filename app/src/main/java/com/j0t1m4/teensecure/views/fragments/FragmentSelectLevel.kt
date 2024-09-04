package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        binding.tvSelectedLevel.text = "Selected Level: $level"
    }

    private fun navigateToNextFragment(level: String) {
        FragmentSelectLevelDirections.actionFragmentSelectLevelToFragmentSelectedLevel(level).apply {
            findNavController().navigate(this)
        }

    }


}