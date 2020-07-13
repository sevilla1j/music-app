package com.jsevilla.musicapp.presentation.navigation

import android.app.Activity
import android.content.Intent
import com.jsevilla.musicapp.R
import com.jsevilla.musicapp.presentation.feature.home.HomeActivity
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

    fun navigateToSearch() {
        TODO("Not yet implemented")
    }

    fun navigateToSetting() {
        TODO("Not yet implemented")
    }
}
