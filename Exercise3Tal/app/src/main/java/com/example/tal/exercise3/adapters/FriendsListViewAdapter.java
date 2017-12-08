package com.example.tal.exercise3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tal.exercise3.R;
import com.example.tal.exercise3.model.Friend;

import java.util.ArrayList;

/**
 * Created by tal on 11/15/17.
 */

public class FriendsListViewAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Friend> mFriends;

    public FriendsListViewAdapter(Context context, ArrayList<Friend> friends) {
        this.mContext = context;
        this.mFriends = friends;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mFriends.size();
    }

    @Override
    public Object getItem(int position) {
        return mFriends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate our row and find our views!
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row , parent, false);
            holder = onCreateViewHolder(convertView);
            } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Getting the data for this specific row!

        Friend friend = (Friend) getItem(position);
        onBindViewHolder(holder, friend);

        return convertView;

    }

    private static class ViewHolder {
        public TextView name;
        public TextView funfact;
    }

    private ViewHolder onCreateViewHolder(View convertView) {
        ViewHolder holder = new ViewHolder();

        holder.name = convertView.findViewById(R.id.tv_name);
        holder.funfact = convertView.findViewById(R.id.tv_funfact);
        convertView.setTag(holder);
        return holder;
    }

    private void onBindViewHolder(ViewHolder holder, Friend friend) {
        holder.name.setText(friend.getName());
        holder.funfact.setText(friend.getFunFact());

    }
}
