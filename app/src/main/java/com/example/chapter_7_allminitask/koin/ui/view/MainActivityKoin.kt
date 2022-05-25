package com.example.chapter_7_allminitask.koin.ui.view

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_7_allminitask.databinding.ActivityMainKoinBinding
import com.example.chapter_7_allminitask.koin.data.Status
import com.example.chapter_7_allminitask.koin.ui.MainActivityViewModelKoin
import com.example.chapter_7_allminitask.koin.ui.adapter.MainAdapterKoin
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivityKoin : AppCompatActivity() {

    private lateinit var binding : ActivityMainKoinBinding
    private val viewModelKoin : MainActivityViewModelKoin by viewModel() //ngambil vm yg qualifier
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: MainAdapterKoin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainKoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        adapter = MainAdapterKoin()
        binding.rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvData.adapter = adapter

        binding.btnGetAllPosts.setOnClickListener {
            viewModelKoin.getAllPosts()
        }

        setupObservers()
    }

    fun setupObservers(){
        viewModelKoin.posts.observe(this){ resource ->
            when(resource.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }

                Status.SUCCESS -> {
                    adapter.submitData(resource.data)
                    Toast.makeText(this, "Response Sukses : ${resource.data?.get(0)?.title}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error get Data : ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}