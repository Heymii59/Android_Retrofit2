package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getVaccine()
    }

    private fun getVaccine() {
        RetrofitObject.getApiService().getInfo(
            1,
            30,
            "OYX/jaNmxOWx6sJGLJpqCDCSGZsdW26LT3J+7mEovNSjl35mPABx7jc0QTHsWVjwXkUfnXmpYD/EXy2+wVx/wQ=="
        ).enqueue(object : Callback<Vaccine> {
            override fun onResponse(call: Call<Vaccine>, response: Response<Vaccine>) {
                mainAdapter = MainAdapter(response.body()!!.data)
                var manager = LinearLayoutManager(applicationContext)

                binding.vaccineRcv.apply {
                    adapter = mainAdapter
                    layoutManager = manager
                }

                Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Vaccine>, t: Throwable) {
                Log.e("Retrofit onFailure", "${t.printStackTrace()}")
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}