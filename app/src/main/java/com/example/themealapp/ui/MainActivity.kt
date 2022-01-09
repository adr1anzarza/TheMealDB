package com.example.themealapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.themealapp.R
import com.example.themealapp.databinding.ActivityMainBinding
import com.example.themealapp.ui.viewmodel.MainActivityViewModel
import com.example.themealapp.ui.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProvider(this, MainActivityViewModelFactory()).get(MainActivityViewModel::class.java)
    }


}