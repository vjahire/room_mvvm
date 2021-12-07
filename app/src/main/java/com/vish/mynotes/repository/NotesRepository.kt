package com.vish.mynotes.repository

import androidx.annotation.WorkerThread
import com.vish.mynotes.dao.NoteDao
import com.vish.mynotes.entities.Note

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes = noteDao.getAllNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

}