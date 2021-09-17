package com.autumnsun.sherlockperiodictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.autumnsun.sherlockperiodictable.adapter.PeriodicTableAdapter
import com.autumnsun.sherlockperiodictable.databinding.ActivityMainBinding
import com.autumnsun.sherlockperiodictable.model.PeriodicTableData

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PeriodicTableData.getPeriodicData()
        val tableAdapter =
            PeriodicTableAdapter(PeriodicTableData.periodicData, supportFragmentManager)
        binding.tableRecyclerview1.adapter = tableAdapter
        binding.tableRecyclerview1.layoutManager = GridLayoutManager(applicationContext, 18)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}