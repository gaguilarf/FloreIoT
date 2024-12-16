package com.techteam.sariseco.intro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.techteam.sariseco.MainActivity
import com.techteam.sariseco.R

class WelcomeFragment : Fragment() {

    private lateinit var btnGo: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_welcome, container, false)

        btnGo = rootView.findViewById(R.id.btnGo)

        btnGo.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        return rootView
    }
}