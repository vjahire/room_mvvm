package com.vish.mynotes.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vish.mynotes.App
import com.vish.mynotes.databinding.ActivityMainBinding
import com.vish.mynotes.entities.Note

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val notesViewModel: NotesViewModel by viewModels {
        NotesViewModel.NotesViewModelFactory((application as App).repository)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fbAdd.setOnClickListener {
            notesViewModel.insert(Note("My Title", "This is description", System.currentTimeMillis().toString()))
        }

        notesViewModel.allNotes.observe(this, Observer {
            Log.i(TAG, "onObserve: $it")
        })
    }
}