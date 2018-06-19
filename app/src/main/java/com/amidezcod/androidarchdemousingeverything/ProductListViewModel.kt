package com.amidezcod.androidarchdemousingeverything

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.util.DiffUtil
import javax.inject.Inject
import javax.inject.Singleton

open class ProductListViewModel(var dataRepository: DataRepository) : ViewModel() {


    fun getAllProduct(): LiveData<List<Product>> = dataRepository.getAllProduct()
    fun insertProduct(product: Product) {
        dataRepository.insertProduct(product)
    }

    fun deleteAll() {
        dataRepository.deleteAll()
    }

    fun insertAll(products: List<Product>) {
        dataRepository.insertAll(products)
    }
}

@Singleton
class factory @Inject
constructor(val dataRepository: DataRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(dataRepository) as T
    }

}

