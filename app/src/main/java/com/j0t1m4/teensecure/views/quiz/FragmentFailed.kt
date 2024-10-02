package com.j0t1m4.teensecure.views.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.databinding.FragmentFailedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFailed : Fragment() {
    private lateinit var binding: FragmentFailedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRetakeQuiz.setOnClickListener {
            findNavController().popBackStack(R.id.fragmentLearningContent, inclusive = false)
        }
    }

}