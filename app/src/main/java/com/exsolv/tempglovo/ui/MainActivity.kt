package com.exsolv.tempglovo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exsolv.tempglovo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commitNow()
        }
    }

    /*fun navigateToProfile() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailsFragment())
            .commitNow()
    }*/
}