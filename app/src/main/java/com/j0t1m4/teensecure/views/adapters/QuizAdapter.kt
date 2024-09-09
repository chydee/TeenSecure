package com.j0t1m4.teensecure.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.j0t1m4.teensecure.data.contents.Question
import com.j0t1m4.teensecure.databinding.ItemQuestionTypeBinding
import com.j0t1m4.teensecure.views.utils.gone
import com.j0t1m4.teensecure.views.utils.visible
import timber.log.Timber

class QuizAdapter(
    private val context: Context,
    private val questions: List<Question>
) : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    inner class QuizViewHolder(private var binding: ItemQuestionTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            /*Glide.with(context).load(featured.featureImage.mobile*//*"https://bafkreiekthwdyf7s2vx7argthd3juo4vza3ucmhslqdkzbekx463b3sm7a.ipfs.w3s.link"*//*).error(R.drawable.jamit_outside_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.featureImage)*/
            // Here, you'll use different layouts depending on question type
            // Hide all views initially
            binding.apply {
                multipleChoiceGroup.gone()
                trueOrFalseLayout.gone()
                matchingLayout.gone()
                visualQuestionImage.gone()
                visualQuestionLayout.gone()
                scenarioBasedLayout.gone()
                multipleAnswerLayout.gone()
            }

            // Set the question text
            binding.questionText.text = when (question) {
                is Question.MultipleChoice -> question.question
                is Question.TrueOrFalse -> question.question
                is Question.ScenarioBased -> question.question
                is Question.Matching -> "Match the following:"
                is Question.Visual -> question.question
                is Question.MultipleAnswer -> question.question
                is Question.FillInTheBlank -> question.question
                is Question.InteractiveQuiz -> question.question
                is Question.DragAndDrop -> "Arrange the items in the correct order:"
                else -> "Unknown Question Type"
            }

            when (question) {
                is Question.MultipleChoice -> {
                    val radioGroup = binding.multipleChoiceGroup
                    radioGroup.visible()
                    radioGroup.removeAllViews() // Clear any existing options

                    // Dynamically add RadioButtons for each option
                    question.options.forEach { option ->
                        val radioButton = RadioButton(context)
                        radioButton.text = option
                        radioGroup.addView(radioButton)
                    }
                }

                is Question.InteractiveQuiz -> {
                    val radioGroup = binding.multipleChoiceGroup
                    radioGroup.visible()
                    radioGroup.removeAllViews() // Clear any existing options

                    // Dynamically add RadioButtons for each option
                    question.options.forEach { option ->
                        val radioButton = RadioButton(context)
                        radioButton.text = option
                        radioGroup.addView(radioButton)
                    }
                }

                is Question.TrueOrFalse -> {
                    binding.trueOrFalseLayout.visible()

                    val trueButton = binding.trueButton
                    val falseButton = binding.falseButton

                    trueButton.setOnClickListener {
                        // Handle the 'True' answer selection
                    }
                    falseButton.setOnClickListener {
                        // Handle the 'False' answer selection
                    }
                }

                is Question.Matching -> {
                    val matchingLayout = binding.matchingLayout
                    matchingLayout.visible()
                    matchingLayout.removeAllViews() // Clear existing views

                    // Dynamically add matching pairs
                    question.pairs.forEach { (left, right) ->
                        val textView = TextView(context)
                        textView.text = "$left - $right"
                        matchingLayout.addView(textView)
                    }
                }

                is Question.Visual -> {
                    val visualImageView = binding.visualQuestionImage
                    visualImageView.visible()
                    // Use Glide or Picasso to load the image from URL
                    // Glide.with(holder.itemView.context).load(question.imageUrl).into(visualImageView)
                    binding.visualQuestionLayout.visible()
                    binding.visualYesButton.setOnClickListener {
                        // Handle the 'Yes' answer selection
                    }
                    binding.visualNoButton.setOnClickListener {
                        // Handle the 'No' answer selection
                    }
                }

                is Question.ScenarioBased -> {
                    Timber.d("Scenerio: ${question.scenario}")
                    binding.scenarioDescription.text = question.scenario
                    binding.scenarioBasedLayout.visible()
                    binding.scenarioOptionsGroup.visible()
                    binding.scenarioOptionsGroup.removeAllViews() // Clear any existing options
                    // Dynamically add options for Scenario-Based question
                    question.options.forEach { option ->
                        val radioButton = RadioButton(context)
                        radioButton.text = option
                        binding.scenarioOptionsGroup.addView(radioButton)
                    }
                }

                is Question.MultipleAnswer -> {
                    val multipleAnswerLayout = binding.multipleAnswerLayout
                    multipleAnswerLayout.visible()
                    multipleAnswerLayout.removeAllViews() // Clear existing views

                    // Dynamically add CheckBoxes for each option
                    question.options.forEach { option ->
                        val checkBox = CheckBox(context)
                        checkBox.text = option
                        multipleAnswerLayout.addView(checkBox)
                    }
                }

                is Question.FillInTheBlank -> {
                    val fillInTheBlankLayout = binding.fillInTheBlankLayout
                    fillInTheBlankLayout.visible()

                    val fillInBlankInput = binding.fillInBlankInput
                    fillInBlankInput.setText("") // Clear any previous input

                    // You can capture the user's input here, e.g., when they submit the quiz
                }

                is Question.DragAndDrop -> {
                    val dragAndDropLayout = binding.dragAndDropLayout
                    dragAndDropLayout.visible()

                    val recyclerView = binding.recyclerViewDragAndDrop

                    // Initialize the adapter with the list of items
                    val adapter = DragAndDropAdapter(question.items.toMutableList())
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.isNestedScrollingEnabled = false

                    // Set up the ItemTouchHelper
                    val itemTouchHelperCallback = DragItemTouchHelperCallback(adapter)
                    val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
                    itemTouchHelper.attachToRecyclerView(recyclerView)
                }


                else -> {
                    // Default case for unsupported or unknown question types
                    binding.questionText.text = "This question type is not supported."
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val binding: ItemQuestionTypeBinding = ItemQuestionTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val question = questions[position]
        holder.bind(question)
    }

    override fun getItemCount(): Int = questions.size
}