package com.example.mytest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.mytest.databinding.ActivityMainBinding
import com.example.mytest.lifecycle.LifecycleActivity
import com.example.mytest.recyclerView.RecyclerViewActivity
import com.example.mytest.underCounter.UnderCounterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, RecyclerViewActivity::class.java)
        binding.recyclerViewButton.setOnClickListener {
            startActivity(intent)
        }
        binding.lifecycleButton.setOnClickListener {
            startActivity(Intent(this, LifecycleActivity::class.java))
        }
        binding.underCountButton.setOnClickListener {
            startActivity(Intent(this, UnderCounterActivity::class.java))
        }
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        );

    }

}