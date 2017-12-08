package com.example.tal.exercise3.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tal.exercise3.R;
import com.example.tal.exercise3.adapters.FriendsListViewAdapter;
import com.example.tal.exercise3.model.Friend;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ArrayList<Friend> mFriends;

    private ListView mListView;
    private FriendsListViewAdapter mAdapter;

    public static Intent getIntent(Context context) {
        return new Intent(context, ListViewActivity.class);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = findViewById(R.id.listview);
        mFriends = Friend.generateFriendList();
        mAdapter = new FriendsListViewAdapter(this, mFriends);
        mListView.setAdapter(mAdapter);
        
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = ((TextView) view.findViewById(R.id.tv_name)).getText().toString();
                String funfact = ((TextView) view.findViewById(R.id.tv_funfact)).getText().toString();

                Toast.makeText(ListViewActivity.this, name + "" + funfact,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
