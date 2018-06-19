package com.amidezcod.androidarchdemousingeverything

import android.app.Application


class DataComponent : Application() {
    companion object {

        lateinit var appComponent: AppComponent

    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

    }


}