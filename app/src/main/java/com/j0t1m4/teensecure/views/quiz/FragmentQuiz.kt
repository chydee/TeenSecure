package com.j0t1m4.teensecure.views.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.core.mechanism.Game
import com.j0t1m4.teensecure.data.contents.Question
import com.j0t1m4.teensecure.databinding.FragmentQuizBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import com.j0t1m4.teensecure.views.adapters.QuizAdapter
import com.j0t1m4.teensecure.views.adapters.QuizNavigationHandler
import com.j0t1m4.teensecure.views.utils.gone
import com.j0t1m4.teensecure.views.utils.visible
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentQuiz : Fragment(), QuizNavigationHandler {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var quizAdapter: QuizAdapter
    private var currentPage = 0
    private var NUM_PAGES = 0
    private val args: FragmentQuizArgs by navArgs<FragmentQuizArgs>()
    private val game = Game()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.secondaryBackground)
        game.totalQuestions = args.questions.size
        quizAdapter = QuizAdapter(requireContext(), args.questions.toList(), game, this)
        implementSlider(args.questions.toList())
        binding.totalQuestionsSize.text = "/${args.questions.size}"/*prevButton.setOnClickListener {
            if (questionViewPager.currentItem > 0) {
                questionViewPager.currentItem = questionViewPager.currentItem - 1
            }
        }*/


        binding.btnSubmit.setOnClickListener {
            FragmentQuizDirections.actionFragmentQuizToFragmentYourScore(game.getTotalScore(), NUM_PAGES).apply {
                findNavController().navigate(this)
            }
        }
    }

    private fun implementSlider(collections: List<Question>) {
        //Set the pager with an adapter
        binding.questionViewPager.adapter = quizAdapter

        val indicator: IndicatorView = binding.indicatorView.apply {
            setSliderWidth(resources.getDimension(R.dimen.slider_width))
            setSliderHeight(resources.getDimension(R.dimen.slider_height))
            setSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorStyle(IndicatorStyle.DASH)
        }

        indicator.setupWithViewPager(binding.questionViewPager)
        NUM_PAGES = collections.size

        binding.questionViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
                //binding.currentQuestionIndex.text = position.toString()
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.onPageSelected(position)
                if (binding.questionViewPager.currentItem == quizAdapter.itemCount - 1) {
                    binding.btnSubmit.visible()
                } else {
                    binding.btnSubmit.gone()
                }
            }
        })
    }

    override fun navigateToNextQuestionOrLevel() {
        if (binding.questionViewPager.currentItem < quizAdapter.itemCount - 1) {
            binding.questionViewPager.currentItem = binding.questionViewPager.currentItem + 1
            currentPage = binding.questionViewPager.currentItem + 1
            binding.currentQuestionIndex.text = currentPage.toString()
        }
    }

}