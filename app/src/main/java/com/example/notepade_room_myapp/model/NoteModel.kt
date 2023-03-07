package com.example.notepade_room_myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val title: String = "",

    @ColumnInfo
    val description: String = ""

) : java.io.Serializable
