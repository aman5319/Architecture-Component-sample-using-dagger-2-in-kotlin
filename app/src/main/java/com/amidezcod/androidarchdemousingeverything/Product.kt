package com.amidezcod.androidarchdemousingeverything

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "product")
data class Product(@PrimaryKey var title: String = "")