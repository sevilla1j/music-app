package com.jsevilla.musicapp.presentation.navigation

import android.app.Activity
import android.content.Intent
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.feature.home.HomeActivity
import com.jsevilla.musicapp.presentation.feature.search.SearchActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject internal constructor() {

    fun navigateToHome(activity: Activity) {
        val intentToLaunch: Intent = HomeActivity.getCallingIntent(activity.applicationContext)
        intentToLaunch.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        activity.applicationContext.startActivity(intentToLaunch)
        activity.overridePendingTransition(R.anim.right_in, R.anim.right_out)
    }

    fun navigateToSearch(activity: Activity) {
        val intentToLaunch: Intent = SearchActivity.getCallingIntent(activity.applicationContext)
        intentToLaunch.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        activity.applicationContext.startActivity(intentToLaunch)
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out)
    }

    fun navigateToSetting(activity: Activity) {
        val intentToLaunch: Intent = SearchActivity.getCallingIntent(activity.applicationContext)
        intentToLaunch.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        activity.applicationContext.startActivity(intentToLaunch)
        activity.overridePendingTransition(R.anim.bounce_in_left, R.anim.bounce_out_right)
    }
}
