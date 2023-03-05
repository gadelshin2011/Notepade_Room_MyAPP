package com.example.notepade_room_myapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notepade_room_myapp.model.NoteModel

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Update
    suspend fun update(noteModel: NoteModel)



    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}