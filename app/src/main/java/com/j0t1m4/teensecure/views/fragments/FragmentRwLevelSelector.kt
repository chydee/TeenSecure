package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import com.j0t1m4.teensecure.data.contents.CourseContent
import com.j0t1m4.teensecure.data.contents.RansomWranglerCourse
import com.j0t1m4.teensecure.databinding.FragmentRwLevelSelectorBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentRwLevelSelector : Fragment() {

    @Inject
    lateinit var settingContext: SharedPreferences
    private lateinit var binding: FragmentRwLevelSelectorBinding
    private var currentLevel: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRwLevelSelectorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.white)
        currentLevel = settingContext.currentLevelRW
        // Update UI based on current level
        updateLevelButtons()

        // Handle button clicks
        handleButtonClicks()
    }

    private fun updateLevelButtons() {
        // Enable buttons up to the current level
        updateButton(binding.btnLevel1, 1)
        updateButton(binding.btnLevel2, 2)
        updateButton(binding.btnLevel3, 3)
        updateButton(binding.btnLevel4, 4)
        updateButton(binding.btnLevel5, 5)
    }

    private fun updateButton(button: MaterialButton, level: Int) {
        if (level <= currentLevel) {
            button.isEnabled = true
            button.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            button.backgroundTintList = (ContextCompat.getColorStateList(requireContext(), R.color.secondaryColor))
        } else {
            button.isEnabled = false
            button.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.black))
            button.backgroundTintList = (ContextCompat.getColorStateList(requireContext(), R.color.gray_c4c4c4))
        }
    }


    private fun handleButtonClicks() {
        binding.btnLevel1.setOnClickListener { navigateToCourseContent(1) }
        binding.btnLevel2.setOnClickListener { navigateToCourseContent(2) }
        binding.btnLevel3.setOnClickListener { navigateToCourseContent(3) }
        binding.btnLevel4.setOnClickListener { navigateToCourseContent(4) }
        binding.btnLevel5.setOnClickListener { navigateToCourseContent(5) }
    }

    private fun navigateToCourseContent(level: Int) {
        var content: CourseContent? = null
        when (level) {
            1 -> content = RansomWranglerCourse.level1Content
            2 -> content = RansomWranglerCourse.level2Content
            3 -> content = RansomWranglerCourse.level3Content
            4 -> content = RansomWranglerCourse.level4Content
            5 -> content = RansomWranglerCourse.level5Content
        }
        // Navigate to CourseContentFragment, passing the selected level
        val action = content?.let { FragmentRwLevelSelectorDirections.actionFragmentRwLevelSelectorToFragmentLearningContent(it, "Ransom Wrangler", level, it.levelTitle) }
        if (action != null) {
            findNavController().navigate(action)
        }
    }
}