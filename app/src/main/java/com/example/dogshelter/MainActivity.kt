package com.example.dogshelter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.dogshelter.adapter.DogAdapter
import com.example.dogshelter.data.DataSource
import com.example.dogshelter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Toast.makeText(this,"App started",Toast.LENGTH_SHORT)
            .show()

        val dataSource = DataSource()
        val dogList = dataSource.getDogs()

        binding.dogRecycler.adapter = DogAdapter(this, dogList)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.dogRecycler)
    }
}