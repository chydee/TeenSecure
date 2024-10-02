package com.j0t1m4.teensecure.views.fragments

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.contents.LearningContent
import com.j0t1m4.teensecure.databinding.FragmentLearningContentBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLearningContent : Fragment() {
    private lateinit var binding: FragmentLearningContentBinding
    private val args by navArgs<FragmentLearningContentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLearningContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.secondaryBackground)
        populateScreen()
    }

    private fun populateScreen() {
        binding.tvLevelTitle.text = args.courseContent.levelTitle
        binding.tvIntroduction.text = args.courseContent.introduction
        binding.tvDescription.text = args.courseContent.description
        binding.tvTips.text = args.courseContent.tips
        addLearningContents(args.courseContent.learningContents, binding.llLearningContents, requireContext())
        binding.btnTextKnowledge.setOnClickListener {
            FragmentLearningContentDirections.actionFragmentLearningContentToFragmentQuiz(game = args.selectedGame, level = args.selectedLevel, courseTitle = args.courseContent.levelTitle, args.courseContent.quiz.toTypedArray()).apply {
                findNavController().navigate(this)
            }
        }
    }

    private fun addLearningContents(learningContents: List<LearningContent>, container: LinearLayout, context: Context) {
        // Loop through the learning contents, skipping the first item (header)
        for (i in 1 until learningContents.size) {
            val content = learningContents[i]

            // Create a TextView for the learning content title
            val titleTextView = TextView(context).apply {
                text = "${i}. ${content.title}"
                textSize = 16f
                setTextColor(ContextCompat.getColor(context, R.color.black))
                setTypeface(null, Typeface.BOLD)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 16, 0, 8)
                }
            }

            // Create a TextView for the learning content description
            val descriptionTextView = TextView(context).apply {
                text = content.content
                textSize = 14f
                setTextColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 0, 16)
                }
            }

            // Add the title and description to the container
            container.addView(titleTextView)
            container.addView(descriptionTextView)
        }
    }


}