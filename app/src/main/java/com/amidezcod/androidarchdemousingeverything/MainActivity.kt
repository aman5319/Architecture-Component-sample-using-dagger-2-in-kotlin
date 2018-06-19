package com.amidezcod.androidarchdemousingeverything

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var ve: ProductListViewModel
    @Inject
    lateinit var s: factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataComponent.appComponent.inject(this)
        val productAdapter = ProductAdapter()
        recycler_View.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = productAdapter
        }

        ve = ViewModelProviders.of(this, s).get(ProductListViewModel::class.java)

        ve.getAllProduct().observe(this, Observer<List<Product>?> {
            productAdapter.addProducts(it!!)
            println("amna $it")
        })

        val r = Random()
        fab.setOnClickListener {
            //            productAdapter.addProducts(listOf(Product("aman 3"), Product("aman 5")))
            val a = ArrayList<Product>()
            for (i in 1..5) {
                a.add(Product("aman ${r.nextInt()}"))
            }
            ve.insertAll(a)
        }
        fab.setOnLongClickListener {
            ve.deleteAll()
            true
        }
    }
}

