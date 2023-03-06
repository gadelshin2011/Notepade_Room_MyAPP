package com.example.notepade_room_myapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notepade_room_myapp.R
import com.example.notepade_room_myapp.databinding.RcItemNotesBinding
import com.example.notepade_room_myapp.model.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rc_item_notes, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text = listNote[position].title
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }


}