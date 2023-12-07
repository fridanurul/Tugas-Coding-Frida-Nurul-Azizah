package com.example.fagmentnavbarhome

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fagmentnavbarhome.databinding.ActivityDetailIlmuwanBinding
import com.example.fagmentnavbarhome.model.Ilmuwan

class DetailIlmuwanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailIlmuwanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailIlmuwanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val data = intent.getParcelableExtra("data", Ilmuwan::class.java)

            if (data != null) {
                binding.apply {
                    ivIlmuwan.setImageResource(data.image)
                    tvName.text = data.name
                    tvDescription.text = data.description
                }
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}