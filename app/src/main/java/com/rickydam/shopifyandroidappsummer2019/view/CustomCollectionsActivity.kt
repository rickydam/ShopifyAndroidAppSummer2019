package com.rickydam.shopifyandroidappsummer2019.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rickydam.shopifyandroidappsummer2019.R
import com.rickydam.shopifyandroidappsummer2019.databinding.ActivityCustomCollectionsBinding
import com.rickydam.shopifyandroidappsummer2019.viewmodel.CustomCollectionsViewModel

class CustomCollectionsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCustomCollectionsBinding
    private lateinit var viewModel: CustomCollectionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_collections)
        binding.customCollectionsRecyclerview.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(CustomCollectionsViewModel::class.java)
        binding.customCollectionsViewModel = viewModel
    }
}