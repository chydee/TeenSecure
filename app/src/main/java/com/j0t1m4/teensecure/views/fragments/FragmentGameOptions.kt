package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.databinding.FragmentGameOptionsBinding
import com.j0t1m4.teensecure.views.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentGameOptions : Fragment() {

    private lateinit var binding: FragmentGameOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setToolbarBgColor(R.color.secondaryBackground)
        binding.optionRansomWrangle.setOnClickListener {
            FragmentGameOptionsDirections.actionFragmentGameOptionsToFragmentRwLevelSelector().apply {
                findNavController().navigate(this)
            }
        }
        binding.optionTeenSecure.setOnClickListener {
            FragmentGameOptionsDirections.actionFragmentGameOptionsToFragmentTopicSelection().apply {
                findNavController().navigate(this)
            }
        }
    }
}