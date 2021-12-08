package com.vish.mynotes.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vish.mynotes.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM NOTES ORDER BY timestamp DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

//    @Query("DELETE FROM NOTES")
//    suspend fun deleteAll()
}