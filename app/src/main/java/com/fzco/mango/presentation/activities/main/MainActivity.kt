package com.fzco.mango.presentation.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.fzco.mango.R
import com.fzco.mango.presentation.common.backpress.BackPressedStrategyOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBackPressedHandling()
    }

    private inner class BackPressedCallback() : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val lastFragment = supportFragmentManager.fragments.lastOrNull()
            if (lastFragment is BackPressedStrategyOwner) {
                lastFragment.handleOnBackPressed()
            } else {
                supportFragmentManager.popBackStack()
            }
        }
    }

    private fun setUpBackPressedHandling() {
        onBackPressedDispatcher.addCallback(BackPressedCallback())
    }
}