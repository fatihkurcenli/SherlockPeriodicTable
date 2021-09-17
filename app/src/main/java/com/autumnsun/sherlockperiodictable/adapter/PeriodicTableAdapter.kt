package com.autumnsun.sherlockperiodictable.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sherlockperiodictable.R
import com.autumnsun.sherlockperiodictable.databinding.TableCardBinding
import com.autumnsun.sherlockperiodictable.model.PeriodicTableModel


class PeriodicTableAdapter(
    private val tableDataList: List<PeriodicTableModel>,
    val supportFragmentManager: FragmentManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        if (viewType == 1) {
            val itemViewSecond = inflater.inflate(R.layout.empty_card_table, parent, false)
            return EmptyCardViewHolder(itemViewSecond)
        } else {
            val itemView = inflater.inflate(R.layout.table_card, parent, false)
            val binding = TableCardBinding.bind(itemView)
            return TableViewHolder(binding, supportFragmentManager)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (tableDataList[position].gone) {
            val holder = holder as EmptyCardViewHolder
            holder.cardView.visibility = View.GONE
        } else {
            val realHolder = holder as TableViewHolder
            val tableDataItem = tableDataList[position]
            holder.bind(tableDataItem, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (tableDataList[position].gone) {
            return 1
        } else {
            return 0
        }
    }

    override fun getItemCount(): Int = tableDataList.size

}




