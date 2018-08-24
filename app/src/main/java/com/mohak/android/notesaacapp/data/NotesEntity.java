package com.mohak.android.notesaacapp.data;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "notes")
public class NotesEntity {



    @PrimaryKey(autoGenerate = true)
    private int id;

    private String note;
    private String category;

    @Ignore
    public NotesEntity(int id, String note, String category) {
        super();
        this.id = id;
        this.note = note;
        this.category = category;
    }

    public NotesEntity(String note, String category) {
        super();
        this.note = note;
        this.category = category;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
