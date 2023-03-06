package com.example.notepade_room_myapp.screens.notebook.start_note_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notepade_room_myapp.REPOSITORY
import com.example.notepade_room_myapp.db.NoteDatabase
import com.example.notepade_room_myapp.db.repository.NoteRealization
import com.example.notepade_room_myapp.model.NoteModel

class StartNoteViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()

        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}