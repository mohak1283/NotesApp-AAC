package com.mohak.android.notesaacapp.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
class NotesEntity(note : String, category : String) {


    @PrimaryKey(autoGenerate = true)
    public var id : Int = 0
    public  var note : String
    public  var category : String

    init {

        this.note = note
        this.category = category

    }

    @Ignore
    constructor( id : Int ,  note : String  ,  category: String) : this(note , category){

        this.id = id
        this.note = note
        this.category = category



    }





}