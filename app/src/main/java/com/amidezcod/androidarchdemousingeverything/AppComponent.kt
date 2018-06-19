package com.amidezcod.androidarchdemousingeverything

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}