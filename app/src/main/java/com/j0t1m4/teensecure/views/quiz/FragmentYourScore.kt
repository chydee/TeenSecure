package com.j0t1m4.teensecure.views.quiz

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.databinding.FragmentYourScoreBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentYourScore : Fragment() {
    private lateinit var binding: FragmentYourScoreBinding
    private val args by navArgs<FragmentYourScoreArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
        animateTextViewToNumber(binding.tvTotalPassed, args.totalScored)
    }

    // Function to animate the TextView from 1 to the target number
    private fun animateTextViewToNumber(textView: TextView, targetNumber: Int, duration: Long = 2000L) {
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


}