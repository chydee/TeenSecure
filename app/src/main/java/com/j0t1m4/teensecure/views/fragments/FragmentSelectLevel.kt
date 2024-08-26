package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.databinding.FragmentSelectLevelBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSelectLevel : Fragment() {
    private lateinit var binding: FragmentSelectLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectLevelBinding.inflate(inflater, container, false)
        return binding.root
    }


}