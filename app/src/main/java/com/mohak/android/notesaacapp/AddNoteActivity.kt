package com.mohak.android.notesaacapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.mohak.android.notesaacapp.UI.NotesRepository

class AddNoteActivity  : AppCompatActivity(){

    private lateinit var editTextCategory : EditText
    private lateinit var editTextNote : EditText
    private lateinit var fabSave : FloatingActionButton
    lateinit var notesCategory : String
    lateinit var notesText : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note);

        editTextCategory = findViewById(R.id.edit_text_category);
        editTextNote = findViewById(R.id.edit_text_note);
        fabSave = findViewById(R.id.fab_save);

        fabSave.setOnClickListener {

            notesCategory = editTextCategory.text.toString();
            notesText = editTextNote.text.toString();

            NotesRepository.insertNoteInDb(notesCategory, notesText);
            finish();
        }
    }
}