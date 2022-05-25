package com.example.chapter_7_allminitask.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter_7_allminitask.R
import com.example.chapter_7_allminitask.databinding.ActivityKoinMainBinding

class koinMain : AppCompatActivity() {

    private lateinit var binding : ActivityKoinMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoinMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}