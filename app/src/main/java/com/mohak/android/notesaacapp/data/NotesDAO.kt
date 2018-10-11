package com.mohak.android.notesaacapp.data

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.provider.ContactsContract


@Dao
interface NotesDAO {

    @Query("SELECT * FROM notes")
    fun getAllNotes() : DataSource.Factory<Int , NotesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(notesEntity : NotesEntity)
}