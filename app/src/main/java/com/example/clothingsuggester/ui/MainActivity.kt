package com.example.clothingsuggester.ui

import android.view.LayoutInflater
import com.example.clothingsuggester.databinding.ActivityMainBinding
import com.example.clothingsuggester.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

}