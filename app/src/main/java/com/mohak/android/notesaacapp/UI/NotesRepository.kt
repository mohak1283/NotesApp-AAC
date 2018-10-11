package com.mohak.android.notesaacapp.UI

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.AsyncTask
import com.mohak.android.notesaacapp.data.AppDatabase
import com.mohak.android.notesaacapp.data.NotesDAO
import com.mohak.android.notesaacapp.data.NotesEntity
import java.util.zip.DataFormatException

class NotesRepository(application: Application) {

    var mDb : AppDatabase

    companion object {
        lateinit var notesDao : NotesDAO
        public fun insertNoteInDb(category: String , note : String){
            var notesEntity : NotesEntity = NotesEntity(note , category)
            mInsertAsyncTask(notesDao).execute(notesEntity)

        }

        public fun getAllNotes(config: PagedList.Config) : LiveData<PagedList<NotesEntity>>{
            var factory : DataSource.Factory<Int , NotesEntity> = notesDao.getAllNotes()

            return LivePagedListBuilder(factory , config).build()
        }
    }




    init {
        mDb = AppDatabase.getInstance(application.applicationContext);
        notesDao = mDb.notesDao();
    }

    class mInsertAsyncTask(notesDAO: NotesDAO) : AsyncTask<NotesEntity, Unit, Unit>() {

        var mNotesDAO: NotesDAO

        init {
            mNotesDAO = notesDAO
        }


        override fun doInBackground(vararg p0: NotesEntity): Unit{
            mNotesDAO.insertNote(p0[0]);





        }


    }





}