package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.databinding.FragmentTopicSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentTopicSelection : Fragment() {

    private lateinit var binding: FragmentTopicSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTopicSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set up click listeners for each topic
        binding.btnPhishing.setOnClickListener {
            navigateToLevelSelection("Phishing")
        }

        binding.btnBaiting.setOnClickListener {
            navigateToLevelSelection("Baiting")
        }

        binding.btnImpersonation.setOnClickListener {
            navigateToLevelSelection("Impersonation")
        }

        binding.btnCyberbullying.setOnClickListener {
            navigateToLevelSelection("Cyberbullying")
        }
    }

    private fun navigateToLevelSelection(topic: String) {
        // Use the Navigation Component to navigate to the level selection screen
        val action = TeenSecureTopicSelectionFragmentDirections
            .actionTeenSecureTopicSelectionFragmentToLevelSelectionFragment(topic)
        findNavController().navigate(action)
    }

}