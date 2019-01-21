package com.rickydam.shopifyandroidappsummer2019.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rickydam.shopifyandroidappsummer2019.R
import com.rickydam.shopifyandroidappsummer2019.databinding.ActivityCustomCollectionsBinding
import com.rickydam.shopifyandroidappsummer2019.viewmodel.CustomCollectionsListViewModel

class CustomCollectionsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCustomCollectionsBinding
    private lateinit var listViewModel: CustomCollectionsListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_collections)
        binding.customCollectionsRecyclerview.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        listViewModel = ViewModelProviders.of(this).get(CustomCollectionsListViewModel::class.java)
        listViewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.customCollectionsListViewModel = listViewModel
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, listViewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}