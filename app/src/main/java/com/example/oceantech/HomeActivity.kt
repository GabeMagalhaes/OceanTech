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

        binding.btReport.setOnClickListener {
            val intent = Intent(this@HomeActivity, ReportActivity::class.java)
            startActivity(intent)
        }


    }
}