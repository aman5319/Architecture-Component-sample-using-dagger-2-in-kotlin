package com.amidezcod.androidarchdemousingeverything

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun getRoomDatabase(application: Application): DemoDatabase = Room.databaseBuilder(application,
            DemoDatabase::class.java,
            "ama").build()

    @Provides
    @Singleton
    fun getProductDao(demoDatabase: DemoDatabase): ProductDao = demoDatabase.getProductDao()

    @Provides
    @Singleton
    fun getDataRepository(productDao: ProductDao): DataRepository {
        return DataRepository(productDao)
    }

}