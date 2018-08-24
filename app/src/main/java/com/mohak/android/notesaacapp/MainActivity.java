package com.mohak.android.notesaacapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mohak.android.notesaacapp.UI.NotesRepository;
import com.mohak.android.notesaacapp.UI.NotesViewModel;
import com.mohak.android.notesaacapp.data.NotesEntity;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotesViewModel notesViewModel;
    private NotesAdapter mAdapter;
    private FloatingActionButton addNoteFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity", "onCreate:");

        addNoteFab = findViewById(R.id.add_note_fab);

        addNoteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        mAdapter = new NotesAdapter(this);

        recyclerView.setAdapter(mAdapter);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        notesViewModel.getNotesEntitiesPagedList().observe(this, new Observer<PagedList<NotesEntity>>() {
            @Override
            public void onChanged(@Nullable PagedList<NotesEntity> notesEntities) {
                if (notesEntities == null || notesEntities.size() == 0) {
                    notesViewModel.getNotesEntitiesPagedList();
                }

                mAdapter.submitList(notesEntities);
            }
        });



    }
}
