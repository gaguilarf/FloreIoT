package com.techteam.sariseco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseApp
import com.techteam.sariseco.databinding.ActivityMainBinding
import com.techteam.sariseco.intro.WelcomeFragment
import com.techteam.sariseco.menu.AutomatizarFragment
import com.techteam.sariseco.menu.HumedadFragment
import com.techteam.sariseco.menu.TemperaturaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)

        val bottomNavigationView = binding.bottomNavView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.temperatura_menu -> loadFragment(TemperaturaFragment())
                R.id.humedad_menu -> loadFragment(HumedadFragment())
                R.id.automatizar_menu -> loadFragment(AutomatizarFragment())
                else -> false
            }
            true
        }

        if (savedInstanceState == null) {
            loadFragment(TemperaturaFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

}