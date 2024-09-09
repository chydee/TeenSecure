package com.j0t1m4.teensecure.views.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.databinding.FragmentCourseCompletedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentCourseCompleted : Fragment() {
    private lateinit var binding: FragmentCourseCompletedBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCourseCompletedBinding.inflate(inflater, container, false)
        return binding.root
    }
}