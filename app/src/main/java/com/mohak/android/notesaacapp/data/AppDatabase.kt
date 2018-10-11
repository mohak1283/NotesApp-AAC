package com.mohak.android.notesaacapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(NotesEntity::class), exportSchema = false, version = 2)
abstract class AppDatabase : RoomDatabase() {

    public abstract fun notesDao() : NotesDAO

    companion object {
         var sInstance : AppDatabase? = null
        fun getInstance(context: Context) : AppDatabase {



            if (sInstance == null){

                synchronized(AppDatabase::class) {

                    if (sInstance == null){

                        sInstance = Room.databaseBuilder(context.applicationContext , AppDatabase::class.java , "notesDB").build()

                    }

                }
            }

            return sInstance!!
        }
    }
}