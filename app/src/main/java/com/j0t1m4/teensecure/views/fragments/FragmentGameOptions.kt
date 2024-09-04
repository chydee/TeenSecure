package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.databinding.FragmentGameOptionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentGameOptions : Fragment() {

    private lateinit var binding: FragmentGameOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

}