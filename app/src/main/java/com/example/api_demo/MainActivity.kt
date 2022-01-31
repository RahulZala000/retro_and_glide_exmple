package com.example.api_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_demo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var dataList = ArrayList < MydataItem > ()
    lateinit var recyclerView: RecyclerView
    //var Base="https://jsonplaceholder.typicode.com/"
    var Base="https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getData()

    }

    private fun getData() {
        var retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base)
            .build()
            .create(ApiInterface::class.java)
        var retroData=retrofitBuilder.getData()

        retroData.enqueue(object : Callback<MutableList<ViewModel>?>{

            override fun onResponse(call: Call<MutableList<ViewModel>?>, response: retrofit2.Response<MutableList<ViewModel>?>)
            {
                    binding.reuse.apply{
                        layoutManager=LinearLayoutManager(this@MainActivity)
                        adapter=CustomAdapter(response.body()!!)
                    }

            }

            override fun onFailure(call: Call<MutableList<ViewModel>?>, t: Throwable) {
                Log.d("MainActivity","onFailure"+t.message)
            }

        })

    }

}