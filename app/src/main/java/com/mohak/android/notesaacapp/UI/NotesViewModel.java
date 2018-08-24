package com.mohak.android.notesaacapp.UI;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.mohak.android.notesaacapp.data.NotesEntity;

public class NotesViewModel extends AndroidViewModel{

    public NotesRepository mRepository;
    private LiveData<PagedList<NotesEntity>> notesEntitiesPagedList;

    private static final PagedList.Config config = new PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(10)
            .build();


    public NotesViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NotesRepository(application);
    }


    public LiveData<PagedList<NotesEntity>> getNotesEntitiesPagedList() {

        notesEntitiesPagedList = NotesRepository.getAllNotes(config);
        return notesEntitiesPagedList;
    }
}
