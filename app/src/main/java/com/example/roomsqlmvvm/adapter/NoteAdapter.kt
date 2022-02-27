package com.example.roomsqlmvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsqlmvvm.R
import com.example.roomsqlmvvm.model.NoteModel
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    private var notes = listOf<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = notes[position].title
    }

    override fun getItemCount(): Int = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNotes(list: List<NoteModel>) {
        notes = list
        notifyDataSetChanged()
    }
}