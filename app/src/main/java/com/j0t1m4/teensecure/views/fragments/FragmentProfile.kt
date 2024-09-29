package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.j0t1m4.teensecure.data.SharedPreferences
import com.j0t1m4.teensecure.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentProfile : Fragment() {
    @Inject
    lateinit var settingContext: SharedPreferences
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvUsername.text = settingContext.username
        binding.tvCurrentGame.text = "Current Game: ${settingContext.currentGame}"
        binding.tvCurrentLevel.text = if (settingContext.currentGame == "Teen Secure") "Current Level: ${settingContext.currentLevelTS}" else "Current Level: ${settingContext.currentLevelRW}"

        binding.btnDeleteMyData.setOnClickListener {
            settingContext.clearAllStoredData()
            activity?.finish()
        }
    }
}