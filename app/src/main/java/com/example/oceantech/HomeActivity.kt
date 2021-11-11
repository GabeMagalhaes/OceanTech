package com.example.oceantech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oceantech.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRelatorio.setOnClickListener {
            val intent = Intent(this@HomeActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }

        binding.btIntegrantes.setOnClickListener {
            val intent = Intent(this@HomeActivity, IntegrantesActivity::class.java)
            startActivity(intent)
        }

    }
}