package com.mohak.android.notesaacapp

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mohak.android.notesaacapp.data.NotesEntity

class NotesAdapter(context : Context) : PagedListAdapter<NotesEntity, NotesAdapter.MyViewHolder>(DIFF_CALLBACK) {

     var context : Context
    init {
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.MyViewHolder {

        var  view : View = LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false);
       //return MyViewHolder
        return NotesAdapter.MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: NotesAdapter.MyViewHolder, position: Int) {


        var notesEntity : NotesEntity = getItem(position)!!
        holder.categoryTextView.text = notesEntity.category
        holder.noteTextView.text = notesEntity.note


    }

     class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

         var  categoryTextView : TextView
         var noteTextView : TextView

        init {
            categoryTextView = itemView.findViewById(R.id.category_textView);
            noteTextView = itemView.findViewById(R.id.note_textView);
        }



    }

    companion object {

        private var DIFF_CALLBACK : DiffUtil.ItemCallback<NotesEntity> = object : DiffUtil.ItemCallback<NotesEntity>() {
            override fun areItemsTheSame(oldItem: NotesEntity?, newItem: NotesEntity?): Boolean {
                return oldItem!!.id == newItem!!.id


            }

            override fun areContentsTheSame(oldItem: NotesEntity?, newItem: NotesEntity?): Boolean {

                return oldItem!!.id == newItem!!.id && oldItem.note == newItem.note && oldItem.category == newItem.category
            }

        }
    }









}