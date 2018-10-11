package com.mohak.android.notesaacapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.mohak.android.notesaacapp.UI.NotesViewModel
import com.mohak.android.notesaacapp.data.NotesEntity


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var notesViewModel : NotesViewModel
    private lateinit var mAdapter : NotesAdapter
    private lateinit var addNoteFab : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("MainActivity", "onCreate:");

        addNoteFab = findViewById(R.id.add_note_fab);



        addNoteFab.setOnClickListener {
            var intent : Intent = Intent(this , AddNoteActivity::class.java)
            startActivity(intent)

        }

        recyclerView = findViewById(R.id.recyclerView);
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this  , LinearLayoutManager.VERTICAL , false)
        recyclerView.layoutManager = layoutManager
        var dividerItemDecoration : DividerItemDecoration = DividerItemDecoration(this , DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)


        mAdapter = NotesAdapter(this)

        recyclerView.adapter = mAdapter

          notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        notesViewModel.getNotesEntitiesPagedList().observe(this , Observer<PagedList<NotesEntity>> { notesEntities ->
            if (notesEntities == null || notesEntities.size == 0){
                notesViewModel.getNotesEntitiesPagedList()
            }
            mAdapter.submitList(notesEntities)
            mAdapter.submitList(notesEntities)
        })
     /**   notesViewModel.getNotesEntitiesPagedList().observe(this, new Observer<PagedList<NotesEntity>>() {
            @Override
            public void onChanged(@Nullable PagedList<NotesEntity> notesEntities) {
                if (notesEntities == null || notesEntities.size() == 0) {
                    notesViewModel.getNotesEntitiesPagedList();
                }

                mAdapter.submitList(notesEntities);
            }
        }); **/




    }
}