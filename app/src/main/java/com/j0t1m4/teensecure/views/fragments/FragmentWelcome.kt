package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.j0t1m4.teensecure.data.SharedPreferences
import com.j0t1m4.teensecure.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentWelcome : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    @Inject
    lateinit var settingContext: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            if (settingContext.username.isNullOrEmpty()) {
                FragmentWelcomeDirections.actionFragmentWelcomeToBottomSheetUserName().apply {
                    findNavController().navigate(this)
                }
            } else {
                FragmentWelcomeDirections.actionFragmentWelcomeToMainActivity().apply {
                    findNavController().navigate(this)
                }
            }
        }
        binding.btnAbout.setOnClickListener {
            FragmentWelcomeDirections.actionFragmentWelcomeToFragmentAbout().apply {
                findNavController().navigate(this)
            }
        }
    }
}