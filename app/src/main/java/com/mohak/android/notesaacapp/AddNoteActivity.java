package com.mohak.android.notesaacapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mohak.android.notesaacapp.UI.NotesRepository;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextCategory, editTextNote;
    private FloatingActionButton fabSave;

    private String notesCategory, notesText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextCategory = findViewById(R.id.edit_text_category);
        editTextNote = findViewById(R.id.edit_text_note);
        fabSave = findViewById(R.id.fab_save);

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               notesCategory = editTextCategory.getText().toString();
               notesText = editTextNote.getText().toString();

               NotesRepository.insertNoteInDb(notesCategory, notesText);
               finish();

            }
        });


    }
}
