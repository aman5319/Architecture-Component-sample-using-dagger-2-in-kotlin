package com.amidezcod.androidarchdemousingeverything

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}