package dev.tal.exercise5tal.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.tal.exercise5tal.R;
import dev.tal.exercise5tal.rest.Hit;

/**
 * Created by tal on 12/3/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<Hit> mDataSource;

    public ImageAdapter(ArrayList<Hit> mDataSource) {
        this.mDataSource = mDataSource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.image_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hit data = mDataSource.get(position);

        Picasso.with(holder.image.getContext())
                .load(data.getPreviewURL())
                .placeholder(R.drawable.loading)
                .into(holder.image);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.size();
    }

    public void setDataSource(List<Hit> mDataSource) {
        this.mDataSource = (ArrayList<Hit>) mDataSource;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.li_image) ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
