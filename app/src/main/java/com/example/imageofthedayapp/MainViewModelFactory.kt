package com.example.imageofthedayapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imageofthedayapp.repository.Repository

class MainViewModelFactory(
    private val reposotory: Repository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  MainViewModel(reposotory) as T
    }
}