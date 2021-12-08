package com.vish.mynotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vish.mynotes.App
import com.vish.mynotes.entities.Note
import com.vish.mynotes.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository) : ViewModel() {

    val allNotes: LiveData<List<Note>> = repository.allNotes

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
//    fun insert(note: Note) = viewModelScope.launch {
//        repository.insert(note)
//    }

    fun insert(note: Note) {
//        viewModelScope
        viewModelScope.launch {
            repository.insert(note)
        }

    }

    class NotesViewModelFactory(private val repository: NotesRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NotesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}