package com.vedantjha.mvvmdaggerdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vedantjha.mvvmdaggerdemo2.databinding.ActivityMainBinding
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var hasInitiatedInitialCall = false
    private var job:Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}