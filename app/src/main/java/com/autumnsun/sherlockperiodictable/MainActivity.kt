package com.autumnsun.sherlockperiodictable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.autumnsun.sherlockperiodictable.adapter.PeriodicTableAdapter
import com.autumnsun.sherlockperiodictable.databinding.ActivityMainBinding
import com.autumnsun.sherlockperiodictable.model.PeriodicTableData

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val tableData by lazy {
        PeriodicTableData.periodicData
    }
    private lateinit var tableAdapter: PeriodicTableAdapter
    private var firstGetData: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {
            firstGetData = savedInstanceState.getBoolean("firstGetData")
        }
        if (firstGetData) {
            PeriodicTableData.getPeriodicData()
            firstGetData=false
        }
        tableAdapter = PeriodicTableAdapter(tableData, supportFragmentManager)
        binding.tableRecyclerview1.adapter = tableAdapter
        binding.tableRecyclerview1.layoutManager = GridLayoutManager(applicationContext, 18)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("firstGetData", false)
    }

    override fun onStop() {
        super.onStop()
        firstGetData = false
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}