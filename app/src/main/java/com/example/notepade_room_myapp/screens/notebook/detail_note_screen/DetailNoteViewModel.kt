package com.example.notepade_room_myapp.screens.notebook.detail_note_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepade_room_myapp.REPOSITORY
import com.example.notepade_room_myapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailNoteViewModel:ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() ->Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
    }
}