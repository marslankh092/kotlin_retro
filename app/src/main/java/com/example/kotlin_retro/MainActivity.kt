package com.example.kotlin_retro

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_retro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    public lateinit var mBinding: ActivityMainBinding
    public lateinit var mAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        with(mBinding) {
            this.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getUserList()
    }

    fun getUserList() {
        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getQuotes("83b533f9", "movie", 1)
                if (response.isSuccessful) {
                    val modelClassMovie: Movies? = response.body()
                    modelClassMovie?.let {
                        // val mOperations: Operations
                        mAdapter =
                            RecyclerAdapter(this@MainActivity, it.Search, object : Operations {
                                override fun detailBtn(search: Search?) {
                                }

                                override fun deleteBtn(search: Search?) {
                                }

                                override fun updateBtn(search: Search?, position: Int) {
                                    val id =
                                        search?.let { it1 ->
                                            RoomDbClient.getInstance(this@MainActivity)?.dao?.upsert(
                                                it1


                                            )
                                        }


                                    // RoomDbClient.getInstance(this@MainActivity,getDao().)
                                }
                            })


                        mBinding.recyclerview.adapter = mAdapter
                    }

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (Ex: Exception) {
                Log.e("Error", Ex.localizedMessage)
            }
        }

    }


}