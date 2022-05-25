package com.example.chapter_7_allminitask.tryHilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.chapter_7_allminitask.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint // Apapun mau dmn pun kalo mau inject hilt make ini
class DaggerHilt : AppCompatActivity() {

    @Inject
    @Named("String1")
    lateinit var testString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_hilt)

        Log.d("DaggerHilt", "Ini dari module $testString")

    }
}