package com.techteam.sariseco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techteam.sariseco.databinding.ActivityLoginBinding
import com.techteam.sariseco.intro.WelcomeFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}