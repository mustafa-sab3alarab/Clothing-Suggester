package com.example.clothingsuggester.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.clothingsuggester.databinding.ActivityMainBinding
import com.example.clothingsuggester.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("MainActivity Created")
    }

}