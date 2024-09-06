package com.j0t1m4.teensecure.views.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.databinding.FragmentYourScoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentYourScore : Fragment() {
    private lateinit var binding: FragmentYourScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentYourScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

}