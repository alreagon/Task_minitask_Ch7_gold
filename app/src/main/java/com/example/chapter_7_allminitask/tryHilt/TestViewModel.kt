package com.example.chapter_7_allminitask.tryHilt

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

class TestViewModel @ViewModelScoped constructor(
    @Named("String2") testString2: String
) : ViewModel() {

    init {
        Log.d("ViewModel", "Test String from viewModel : $testString2")
    }
}