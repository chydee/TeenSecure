package com.j0t1m4.teensecure.views.adapters


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.j0t1m4.teensecure.core.mechanism.Game
import com.j0t1m4.teensecure.data.contents.Question
import com.j0t1m4.teensecure.databinding.ItemQuestionTypeBinding
import com.j0t1m4.teensecure.views.utils.gone
import com.j0t1m4.teensecure.views.utils.visible
import timber.log.Timber

class QuizAdapter(
    private val context: Context, private val questions: List<Question>, private val game: Game, private val navigationHandler: QuizNavigationHandler
) : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    inner class QuizViewHolder(private var binding: ItemQuestionTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        private var userAnswer: Any? = null
        private var dragAndDropAdapter: DragAndDropAdapter? = null
        private var matchingAdapter: MatchingAdapter? = null


        fun bind(question: Question) {
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

                    // Listen for the user's selection
                    radioGroup.setOnCheckedChangeListener { group, checkedId ->
                        val radioButton = group.findViewById<RadioButton>(checkedId)
                        userAnswer = radioButton.text
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

                    // Listen for the user's selection
                    radioGroup.setOnCheckedChangeListener { group, checkedId ->
                        val radioButton = group.findViewById<RadioButton>(checkedId)
                        userAnswer = radioButton.text
                    }
                }

                is Question.TrueOrFalse -> {
                    binding.trueOrFalseLayout.visible()

                    val trueButton = binding.trueButton
                    val falseButton = binding.falseButton

                    trueButton.setOnClickListener { userAnswer = "True" }
                    falseButton.setOnClickListener { userAnswer = "False" }
                }

                is Question.DragAndDrop -> {
                    val dragAndDropLayout = binding.dragAndDropLayout
                    dragAndDropLayout.visible()

                    val recyclerView = binding.recyclerViewDragAndDrop

                    // Initialize the adapter with the list of items
                    dragAndDropAdapter = DragAndDropAdapter(question.items.toMutableList())
                    recyclerView.adapter = dragAndDropAdapter
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.isNestedScrollingEnabled = false

                    // Set up the ItemTouchHelper
                    val itemTouchHelperCallback = DragItemTouchHelperCallback(dragAndDropAdapter!!)
                    val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
                    itemTouchHelper.attachToRecyclerView(recyclerView)
                }

                is Question.Matching -> {
                    val matchingLayout = binding.matchingLayout
                    matchingLayout.visible()

                    // Initialize the RecyclerView for matching question
                    matchingAdapter = MatchingAdapter(question.pairs.toList())
                    val recyclerView = binding.recyclerViewMatchingPairs
                    recyclerView.apply {
                        adapter = matchingAdapter
                        layoutManager = LinearLayoutManager(context)
                        isNestedScrollingEnabled = false
                    }
                    // Collect the user's answers from the matching adapter
                    userAnswer = matchingAdapter?.getUserMatches()
                }

                is Question.Visual -> {
                    val visualImageView = binding.visualQuestionImage
                    visualImageView.visible()
                    // Use Glide or Picasso to load the image from URL
                    Glide.with(visualImageView.context).load(question.imageUrl).into(visualImageView)
                    binding.visualQuestionLayout.visible()
                    binding.visualYesButton.setOnClickListener {
                        userAnswer = "True"
                    }
                    binding.visualNoButton.setOnClickListener {
                        userAnswer = "False"
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

                    binding.scenarioOptionsGroup.setOnCheckedChangeListener { group, checkedId ->
                        val radioButton = group.findViewById<RadioButton>(checkedId)
                        userAnswer = radioButton.text
                    }
                }

                is Question.MultipleAnswer -> {
                    val multipleAnswerLayout = binding.multipleAnswerLayout
                    multipleAnswerLayout.visible()
                    multipleAnswerLayout.removeAllViews() // Clear existing views
                    val selectedAnswers = mutableListOf<String>()

                    // Dynamically add CheckBoxes for each option
                    question.options.forEach { option ->
                        val checkBox = CheckBox(context)
                        checkBox.text = option
                        checkBox.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                selectedAnswers.add(option)
                            } else {
                                selectedAnswers.remove(option)
                            }
                            userAnswer = selectedAnswers
                        }
                        multipleAnswerLayout.addView(checkBox)
                    }
                }

                is Question.FillInTheBlank -> {
                    val fillInTheBlankLayout = binding.fillInTheBlankLayout
                    fillInTheBlankLayout.visible()

                    val fillInBlankInput = binding.fillInBlankInput
                    fillInBlankInput.setText("") // Clear any previous input

                    userAnswer = fillInBlankInput.text.toString()
                }
            }

            // Check if this is the first question, hide the "Previous" button
            if (bindingAdapterPosition == 0) {
                binding.btnPrevious.gone()  // Hide the Previous button
            } else {
                binding.btnPrevious.visible()  // Show the Previous button
            }

            // Check if this is the last question
            if (bindingAdapterPosition == questions.size - 1) {
                binding.btnNext.text = "Submit"
            } else {
                binding.btnNext.text = "Next"
            }

            binding.btnPrevious.setOnClickListener {
                // Proceed to the previous question
                navigationHandler.navigateToPreviousQuestionOrLevel()
            }

            binding.btnNext.setOnClickListener {
                // Check if userAnswer matches the correct answer for the current question
                when (question) {
                    is Question.MultipleChoice -> {
                        evaluateAnswer(userAnswer, question.correctAnswer, question.reward)
                    }

                    is Question.TrueOrFalse -> {
                        evaluateAnswer(userAnswer, question.correctAnswer, question.reward)
                    }

                    is Question.Visual -> {
                        evaluateAnswer(userAnswer, question.correctAnswer, question.reward)
                    }

                    is Question.ScenarioBased -> {
                        evaluateAnswer(userAnswer, question.correctAnswer, question.reward)
                    }

                    is Question.MultipleAnswer -> {
                        if ((userAnswer as List<*>).containsAll(question.correctAnswers)) {
                            game.addScore(question.reward, true)
                        } else {
                            game.addScore(0, isCorrect = false)
                        }
                    }

                    is Question.Matching -> {
                        evaluateAnswer(userAnswer, null, question.reward)
                    }

                    is Question.FillInTheBlank -> {
                        evaluateAnswer(userAnswer, question.correctAnswer, question.reward)
                    }

                    is Question.DragAndDrop -> {
                        userAnswer = dragAndDropAdapter?.getItems()
                        evaluateAnswer(userAnswer, question.correctOrder, question.reward)
                    }

                    else -> evaluateAnswer(null, null, 0)
                }
            }
        }

        private fun evaluateAnswer(userAnswer: Any?, correctAnswer: Any?, reward: Int) {
            if (userAnswer != null) {
                if (correctAnswer == null) {
                    game.addScore(reward, isCorrect = false)
                } else if (userAnswer == correctAnswer) {
                    game.addScore(reward, isCorrect = true)
                } else {
                    game.addScore(0, false)
                }
                // Proceed to the next question or finish the quiz
                navigationHandler.navigateToNextQuestionOrLevel()
            } else {
                vibratePhone()
                Toast.makeText(context, "Please select an answer to continue!", Toast.LENGTH_SHORT).show()
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

    private fun vibratePhone() {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION") vibrator.vibrate(500)
            }
        }
    }

    fun combineImages(context: Context, leftImageResId: Int, rightImageResId: Int): Bitmap {
        // Load the two images as bitmaps
        val leftBitmap = BitmapFactory.decodeResource(context.resources, leftImageResId)
        val rightBitmap = BitmapFactory.decodeResource(context.resources, rightImageResId)

        // Get the width and height of both images
        val width = leftBitmap.width + rightBitmap.width
        val height = maxOf(leftBitmap.height, rightBitmap.height)

        // Create a new bitmap with combined width and maximum height
        val combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        // Create a canvas to draw the bitmaps
        val canvas = Canvas(combinedBitmap)
        // Draw the first image (left) at position (0, 0)
        canvas.drawBitmap(leftBitmap, 0f, 0f, null)
        // Draw the second image (right) at position (leftBitmap.width, 0)
        canvas.drawBitmap(rightBitmap, leftBitmap.width.toFloat(), 0f, null)

        return combinedBitmap
    }

}

interface QuizNavigationHandler {
    fun navigateToNextQuestionOrLevel()
    fun navigateToPreviousQuestionOrLevel()
}