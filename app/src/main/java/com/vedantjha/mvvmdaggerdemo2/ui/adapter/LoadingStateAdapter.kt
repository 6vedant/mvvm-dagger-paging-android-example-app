package com.vedantjha.mvvmdaggerdemo2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vedantjha.mvvmdaggerdemo2.databinding.NetworkStateItemBinding

class LoadingStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoadingStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        val progressBar = holder.binding.progressBarItem
        val textErrorMessage = holder.binding.errorMsgItem
        val errorButton = holder.binding.retryBtn

        progressBar.isVisible = loadState is LoadState.Loading
        textErrorMessage.isVisible = loadState is LoadState.Error
        errorButton.isVisible = loadState is LoadState.Error

        if (loadState is LoadState.Error) {
            textErrorMessage.text = loadState.error.localizedMessage
        }

        errorButton.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            NetworkStateItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class LoadStateViewHolder(val binding: NetworkStateItemBinding) :
        RecyclerView.ViewHolder(binding.root)


}