package com.yujeong.bigbig.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.util.Log
import java.lang.Exception
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

fun launchingOtherApp(context : Context, intent : Intent) : Intent {

    val packageManager : PackageManager = context.packageManager
    val resolveInfo : ResolveInfo? = packageManager.resolveActivity(intent, 0)
    val launchInent = Intent(Intent.ACTION_MAIN)
    Log.d("***********launchIntent.component", launchInent.component.toString())

    var packageName = ""
    var className = ""


    resolveInfo?.let {
        packageName = resolveInfo.activityInfo.packageName
        className = resolveInfo.activityInfo.name
    }

    launchInent.component = ComponentName(packageName, className)
    launchInent.addCategory(Intent.CATEGORY_LAUNCHER)

    return launchInent
}
