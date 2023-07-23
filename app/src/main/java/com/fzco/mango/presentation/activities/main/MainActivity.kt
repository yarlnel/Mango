package com.fzco.mango.presentation.activities.main

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.fzco.mango.R
import com.fzco.mango.presentation.common.backpress.BackPressedStrategyOwner
import com.fzco.mango.presentation.navigation.graph.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.container)

    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.navigateTo(Screens.SendAuthCode())
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

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun setUpBackPressedHandling() {
        onBackPressedDispatcher.addCallback(BackPressedCallback())
    }
}