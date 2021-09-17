package com.autumnsun.sherlockperiodictable.adapter

import android.graphics.Color
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sherlockperiodictable.databinding.TableCardBinding
import com.autumnsun.sherlockperiodictable.model.PeriodicTableModel
import com.autumnsun.sherlockperiodictable.util.MyDialog

class TableViewHolder(
    private val binding: TableCardBinding,
    private val supportFragmentManager: FragmentManager
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: PeriodicTableModel, position: Int) {
        binding.symbol = model.symbol
        if (model.id != null) {
            binding.number = "${model.id.plus(1)}"
        }
        binding.cardItem.setOnClickListener {
            MyDialog(model).show(supportFragmentManager, "MyDialog")
        }
        binding.cardItem.setBackgroundColor(Color.parseColor(model.cpkHex))
        binding.cardItem.radius = 10f
    }
}
