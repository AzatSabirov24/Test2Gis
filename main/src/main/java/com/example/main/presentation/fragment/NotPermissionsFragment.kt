package com.example.main.presentation.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.main.R
import com.example.main.databinding.FragmentNotPermissionsBinding

class NotPermissionsFragment : Fragment(R.layout.fragment_not_permissions) {

    private val viewBinding by viewBinding(FragmentNotPermissionsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.permissionsButton.setOnClickListener {
            Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    addCategory(Intent.CATEGORY_DEFAULT)
                    data = Uri.parse("package:${requireActivity().packageName}")
                }
                    .run(::startActivity)
        }
    }
}