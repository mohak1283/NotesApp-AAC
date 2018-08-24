package com.mohak.android.notesaacapp.data;


import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {NotesEntity.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {

        if (sInstance == null) {

            synchronized (AppDatabase.class) {

                if (sInstance == null) {

                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "notesdb")
                            .build();

                }

            }
        }
        return sInstance;

    }
}