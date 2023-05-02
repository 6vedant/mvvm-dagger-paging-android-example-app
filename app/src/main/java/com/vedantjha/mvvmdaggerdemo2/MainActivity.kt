package com.vedantjha.mvvmdaggerdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.vedantjha.mvvmdaggerdemo2.data.model.ImageResponse
import com.vedantjha.mvvmdaggerdemo2.databinding.ActivityMainBinding
import com.vedantjha.mvvmdaggerdemo2.ui.adapter.ImagePagingAdapter
import com.vedantjha.mvvmdaggerdemo2.ui.adapter.LoadingStateAdapter
import com.vedantjha.mvvmdaggerdemo2.ui.viewmodels.ImageListViewModel
import com.vedantjha.mvvmdaggerdemo2.utils.toast
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var hasInitiatedInitialCall = false

    private var job: Job? = null

    private var adapter: ImagePagingAdapter = ImagePagingAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ImageListViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()

        if (!hasInitiatedInitialCall) {
            getImages()
            hasInitiatedInitialCall = false
        }

    }

    private fun getImages() {
        job?.cancel()
        lifecycleScope.launch {
            viewModel.getImages().collect {
                adapter.submitData(it)
            }
        }
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter.withLoadStateFooter(
            LoadingStateAdapter {
                adapter.retry()
            }
        )

        adapter.addLoadStateListener {
            toast("Loading...")

            if (it.refresh is LoadState.Error) {
                toast("Error Occurred!")
            }
        }
    }

}