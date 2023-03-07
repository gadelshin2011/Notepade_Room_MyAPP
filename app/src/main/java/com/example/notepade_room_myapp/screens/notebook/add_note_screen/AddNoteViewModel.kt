package com.example.notepade_room_myapp.screens.notebook.add_note_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.RemoteMediator
import com.example.notepade_room_myapp.REPOSITORY
import com.example.notepade_room_myapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel:ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() ->Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
    }

}