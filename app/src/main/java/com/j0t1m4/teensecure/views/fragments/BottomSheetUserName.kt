package com.j0t1m4.teensecure.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import com.j0t1m4.teensecure.databinding.BottomSheetUserNameBinding
import com.j0t1m4.teensecure.views.utils.takeText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class BottomSheetUserName : BottomSheetDialogFragment() {

    @Inject
    lateinit var settingContext: SharedPreferences
    private lateinit var binding: BottomSheetUserNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = BottomSheetUserNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveUsername.setOnClickListener {
            if (binding.edtUserName.takeText().isNullOrEmpty()) {
                binding.layoutUserName.error = "Username required for identification!"
                return@setOnClickListener
            } else {
                binding.layoutUserName.error = null
                settingContext.username = binding.edtUserName.takeText()
                BottomSheetUserNameDirections.actionBottomSheetUserNameToMainActivity().apply {
                    findNavController().navigate(this)
                }
                dismiss()
            }
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

}