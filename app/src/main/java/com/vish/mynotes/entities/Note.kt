package com.vish.mynotes.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "timestamp")
    val timestamp: String
) {
    @PrimaryKey(autoGenerate = true)
    val id = 0

}
