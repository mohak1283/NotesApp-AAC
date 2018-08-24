package com.mohak.android.notesaacapp.data;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    DataSource.Factory<Integer, NotesEntity> getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NotesEntity notesEntity);



}
