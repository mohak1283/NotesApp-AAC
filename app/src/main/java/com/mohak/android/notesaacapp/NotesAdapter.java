package com.mohak.android.notesaacapp;


import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mohak.android.notesaacapp.data.NotesEntity;

public class NotesAdapter extends PagedListAdapter<NotesEntity, NotesAdapter.MyViewHolder>{

    private Context context;

    public NotesAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final NotesEntity notesEntity = getItem(position);
        holder.categoryTextView.setText(notesEntity.getCategory());
        holder.noteTextView.setText(notesEntity.getNote());



    }




    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTextView, noteTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.category_textView);
            noteTextView = itemView.findViewById(R.id.note_textView);
        }
    }


    private static DiffUtil.ItemCallback<NotesEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<NotesEntity>() {
        @Override
        public boolean areItemsTheSame(NotesEntity oldItem, NotesEntity newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(NotesEntity oldItem, NotesEntity newItem) {
            return oldItem.getId() == newItem.getId() && oldItem.getNote() == newItem.getNote() && oldItem.getCategory() == newItem.getCategory();
        }
    };

}
