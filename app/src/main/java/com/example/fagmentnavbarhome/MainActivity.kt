package com.example.fagmentnavbarhome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fagmentnavbarhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(fragment_Home())


        binding.bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(fragment_Home())
                R.id.search -> replaceFragment(Fragment_search())
                R.id.profil -> replaceFragment(Fragment_profil())
                else -> {
                }
            }
            true
        }
    }

    private  fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransction = fragmentManager.beginTransaction()
        fragmentTransction.replace(R.id.framelayout,fragment)
        fragmentTransction.commit()
    }
}