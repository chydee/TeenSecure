package com.j0t1m4.teensecure.views.quiz

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import com.j0t1m4.teensecure.databinding.FragmentYourScoreBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentYourScore : Fragment() {
    @Inject
    lateinit var settingContext: SharedPreferences
    private lateinit var binding: FragmentYourScoreBinding
    private val args by navArgs<FragmentYourScoreArgs>()
    private var currentLevel: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentYourScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.secondaryBackground)
        binding.tvTotalPassed.text = args.totalScored.toString()
        binding.tvTotalQuestions.text = "/100"
        animateTextViewToNumber(binding.tvTotalPassed, if (args.totalScored > 100) 100 else args.totalScored)
        updateUserProgress()
        binding.btnShare.setOnClickListener {
            shareQuizResult(args.totalScored)
        }
        binding.btnContinue.setOnClickListener {
            if (args.totalScored >= 75) {
                FragmentYourScoreDirections.actionFragmentYourScoreToFragmentCourseCompleted(args.game, currentLevel, args.courseTitle).apply {
                    findNavController().navigate(this)
                }
            } else {
                FragmentYourScoreDirections.actionFragmentYourScoreToFragmentFailed().apply {
                    findNavController().navigate(this)
                }
            }
        }
    }

    // Function to animate the TextView from 1 to the target number
    private fun animateTextViewToNumber(textView: TextView, targetNumber: Int, duration: Long = 3000L) {
        // Create a ValueAnimator that goes from 1 to the target number
        val valueAnimator = ValueAnimator.ofInt(1, targetNumber)
        // Set the duration of the animation
        valueAnimator.duration = duration
        // Add an update listener to update the text of the TextView with the current animated value
        valueAnimator.addUpdateListener { animator ->
            val animatedValue = animator.animatedValue as Int
            textView.text = animatedValue.toString()
        }
        // Start the animation
        valueAnimator.start()
    }

    // Function to share the quiz result
    private fun shareQuizResult(score: Int) {
        // Create the content to be shared
        val message = "I just scored $score out of 100 in the ${args.game}: ${args.courseTitle} Quiz! 🎉 Can you beat my score? 🧠💡"

        // Create an intent to share the message
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }

        // Launch the share chooser
        startActivity(Intent.createChooser(shareIntent, "Share your quiz result via"))
    }

    // Call this method to update the current level after passing each level
    private fun updateUserProgress() {
        settingContext.currentGame = args.game
        settingContext.currentTopic = args.courseTitle
        if (args.game == "Teen Secure") {
            currentLevel = if (args.totalScored >= 75) args.level + 1 else args.level
            settingContext.currentLevelTS = currentLevel
        } else {
            currentLevel = if (args.totalScored >= 75) args.level + 1 else args.level
            settingContext.currentLevelRW = currentLevel
        }
    }


}