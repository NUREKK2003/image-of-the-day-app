package com.example.imageofthedayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.imageofthedayapp.databinding.ActivityMainBinding
import com.example.imageofthedayapp.repository.Repository

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response",response.body()?.url.toString()!!)
                //binding.test.text = response.body()?.url.toString()!!
                Glide.with(this).load(response.body()?.url.toString()!!).into(binding.imageOfTheDay)
                binding.titleOfThePhoto.text = response.body()?.title.toString()!!
                binding.imageDescription.text = response.body()?.explanation.toString()!!
                binding.imageDate.text = response.body()?.date.toString()!!
            }else{
                Log.d("Response",response.errorBody().toString())
                //binding.test.text = response.errorBody().toString()
            }

        })
    }
}