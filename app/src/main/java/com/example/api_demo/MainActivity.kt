package com.example.api_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_demo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

   // var Base="https://jsonplaceholder.typicode.com/"
   // var Base="https://reqres.in/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // getData()
        ListingData()


        binding.sub.setOnClickListener()
        {
            getData()
        }
    }

    fun getData()
    {
        var api:ApiInterface=retroapi().getData().create(ApiInterface::class.java)
        var retrodata=api.info()

        retrodata.enqueue(object : Callback<profile>{
            override fun onResponse(call: Call<profile>, response: Response<profile>)
            {

                Log.d("success 2","pass")
                //var Res=response.body()
                var mystr= StringBuilder()
                var Res = listOf(response.body())

                Toast.makeText(this@MainActivity,"success ${Res}",Toast.LENGTH_LONG).show()

               for(Mydata in Res)
                {
                    mystr.append(Mydata!!.data)
                    mystr.append("\n")
                    mystr.append(Mydata.page)
                    mystr.append("\n")
                    mystr.append(Mydata.total_pages)
                    mystr.append("\n\n")

                }


                /*  if(Mydata.id%10==0)
                      mystr.append("\n")*/
                binding.ans.text=mystr
            }
            override fun onFailure(call: Call<profile>, t: Throwable) {
                Log.d("failed","fail :"+t.message)
            }
        })

    }

    fun ListingData()
    {

        var api:ApiInterface=retroapi().getData().create(ApiInterface::class.java)
        var retrodata=api.getProfile()

        retrodata.enqueue(object : Callback<Data>{
            override fun onResponse(call: Call<Data>, response: Response<Data>)
            {

                Log.d("success","pass")
            //var Res=response.body()
               var Res = listOf(response.body())

                Toast.makeText(this@MainActivity,"success ${Res}",Toast.LENGTH_LONG).show()

              //  for(mydata in Res)
                var mystr= StringBuilder()
                        mystr.append("\n")
                        /*  if(Mydata.id%10==0)
                              mystr.append("\n")*/
                binding.ans.text=mystr
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
              Log.d("failed","fail :"+t.message)
            }
        })





    }



   /* private fun getData()
    {
        var retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base)
            .build()
            .create(ApiInterface::class.java)
        var retroData=retrofitBuilder.getData()





        retroData.enqueue(object : Callback<MutableList<Data>?>
        {
            override fun onResponse(call: Call<MutableList<Data>?>, response: Response<MutableList<Data>?>)
            {

                binding.reuse.apply{
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = CustomAdapter(response.body()!!)

                }

            }


            override fun onFailure(call: Call<MutableList<Data>?>, t: Throwable)
            {
                Log.d("MainActivity", "onFailure" + t.message)
                Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT).show()
            }
        })
    }*/
}





