package com.amidezcod.androidarchdemousingeverything

import android.arch.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(val productDao: ProductDao) {

    fun getAllProduct(): LiveData<List<Product>> = productDao.getAllProduct()

    fun insertProduct(product: Product) {
        Util.executeAsynchronously({ productDao.insertProuct(product) })

    }

    fun deleteAll() {
        Util.executeAsynchronously({ productDao.deleteAll() })
    }

    fun insertAll(products: List<Product>) {
        Util.executeAsynchronously({ productDao.insertAll(products) })
    }


}