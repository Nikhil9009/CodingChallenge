package com.sample.wireviewer.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.wireviewer.R
import com.sample.wireviewer.data.RelatedTopic

class CharacterListAdapter(private val mList: List<RelatedTopic>,
private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.text
        holder.textView.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}