package com.yujeong.bigbig

import android.app.Application
import com.yujeong.bigbig.data.BigBigSharedPreference

class BigBigApplication  : Application() {
    override fun onCreate() {
        super.onCreate()

        BigBigSharedPreference.init(applicationContext)
    }
}