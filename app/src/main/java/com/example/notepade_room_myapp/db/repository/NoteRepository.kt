package com.example.notepade_room_myapp.db.repository

import androidx.lifecycle.LiveData
import com.example.notepade_room_myapp.model.NoteModel

interface NoteRepository {

    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun updateNote(noteModel: NoteModel, onSuccess: () -> Unit)
}