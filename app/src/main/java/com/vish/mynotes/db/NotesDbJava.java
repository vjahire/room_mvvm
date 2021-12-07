package com.vish.mynotes.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vish.mynotes.dao.NoteDao;

public abstract class NotesDbJava extends RoomDatabase {

    public static final String DB_NAME = "Notes_db";
    private volatile static NotesDbJava instance;

    //Create singleton instance
    //by using synchronized keyword -> only 1 thread can access the function at a time, another thread will wait
    public static synchronized NotesDbJava getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NotesDbJava.class, DB_NAME)
                    .build();
        }
        return instance;
    }

    public abstract NoteDao getNoteDao();


}
