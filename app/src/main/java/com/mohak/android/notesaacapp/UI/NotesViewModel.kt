package com.mohak.android.notesaacapp.UI

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import android.support.annotation.NonNull
import com.mohak.android.notesaacapp.data.NotesEntity

class NotesViewModel(application: Application) : AndroidViewModel(application) {



     var mRepository : NotesRepository
   private lateinit var notesEntitiesPagedList : LiveData<PagedList<NotesEntity>>

    init {
        mRepository = NotesRepository(application)

    }



    companion object {
        private final var config : PagedList.Config = PagedList.Config.Builder()
                .setPageSize(10)
                .setInitialLoadSizeHint(10)
                .setPrefetchDistance(10)
                .build()
    }




    fun getNotesEntitiesPagedList() : LiveData<PagedList<NotesEntity>>{

        notesEntitiesPagedList = NotesRepository.getAllNotes(config)
        return notesEntitiesPagedList

    }

}