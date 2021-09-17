package com.autumnsun.sherlockperiodictable.adapter

import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sherlockperiodictable.R
import com.autumnsun.sherlockperiodictable.model.PeriodicTableModel

class EmptyCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val cardView = itemView.findViewById<CardView>(R.id.gone_card_item);

    fun bind(itemModel:PeriodicTableModel){
        cardView.visibility=View.GONE
    }
}