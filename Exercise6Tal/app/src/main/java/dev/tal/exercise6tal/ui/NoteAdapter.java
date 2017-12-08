package dev.tal.exercise6tal.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.tal.exercise6tal.R;
import dev.tal.exercise6tal.db.Note;

/**
 * Created by tal on 12/7/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> implements View.OnClickListener {



    public NoteAdapter() {
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title) public TextView tvTitle;
        @BindView(R.id.tv_body) public TextView tvBody;

        public ViewHolder(View itemView, View mView, TextView tvTitle, TextView tvBody) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View view) {

    }

}
