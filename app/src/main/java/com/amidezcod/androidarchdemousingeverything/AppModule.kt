package com.amidezcod.androidarchdemousingeverything

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {


    @Provides
    @Singleton
    fun getApplication(): Application = app

}