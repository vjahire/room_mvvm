package com.vish.mynotes

import android.app.Application
import com.vish.mynotes.db.NotesDatabase
import com.vish.mynotes.repository.NotesRepository

class App: Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { NotesDatabase.getDatabase(this) }
    val repository by lazy { NotesRepository(database.noteDao()) }
}