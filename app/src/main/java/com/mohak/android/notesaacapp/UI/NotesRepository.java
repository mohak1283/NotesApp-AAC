package com.mohak.android.notesaacapp.UI;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.os.AsyncTask;

import com.mohak.android.notesaacapp.data.AppDatabase;
import com.mohak.android.notesaacapp.data.NotesDao;
import com.mohak.android.notesaacapp.data.NotesEntity;

public class NotesRepository {

    public static NotesDao notesDao;
    private AppDatabase mDb;


    public NotesRepository(Application application) {
        super();
        mDb = AppDatabase.getInstance(application.getApplicationContext());
        notesDao = mDb.notesDao();
    }

    public static void insertNoteInDb(String category, String note) {

        NotesEntity notesEntity = new NotesEntity(note, category);
        new mInsertAsyncTask(notesDao).execute(notesEntity);
    }


    public static LiveData<PagedList<NotesEntity>> getAllNotes(PagedList.Config config) {

        DataSource.Factory<Integer, NotesEntity> factory = notesDao.getAllNotes();
        return new LivePagedListBuilder(factory, config).build();

    }






    public static class mInsertAsyncTask extends AsyncTask<NotesEntity, Void, Void> {

        private NotesDao mNotesDao;

        public mInsertAsyncTask(NotesDao notesDao) {
            super();
            mNotesDao = notesDao;
        }

        @Override
        protected Void doInBackground(NotesEntity... notesEntities) {

            mNotesDao.insertNote(notesEntities[0]);

            return null;
        }
    }


}
