package com.example.mynotes.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynotes.Models.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id asc")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("UPDATE notes_table Set title = :title , note =:note Where id=:id")
    suspend fun update(id: Int?, title: String?, note: String?)
}