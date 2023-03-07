package com.example.notepade_room_myapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notepade_room_myapp.APP
import com.example.notepade_room_myapp.R
import com.example.notepade_room_myapp.databinding.RcItemNotesBinding
import com.example.notepade_room_myapp.model.NoteModel
import com.example.notepade_room_myapp.screens.notebook.start_note_screen.StartNoteFragment

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
       holder.itemView.setOnClickListener {
           Toast.makeText(APP, "$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }
    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartNoteFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }


}