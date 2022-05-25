package com.example.chapter_7_allminitask

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter_7_allminitask.databinding.ActivityMainBinding
import com.example.chapter_7_allminitask.koin.ui.view.MainActivityKoin
import org.koin.android.BuildConfig

//import com.example.chapter_7_allminitask.tryHilt.DaggerHilt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, BuildConfig.BUILD_TYPE, Toast.LENGTH_SHORT).show()

//        binding.NyobaHilt.setOnClickListener {
//            val Intent = Intent(this, DaggerHilt::class.java)
//            startActivity(Intent)
//        }
        binding.koin.setOnClickListener {
            val Intent = Intent(this, MainActivityKoin::class.java)
            startActivity(Intent)
        }

    }
}