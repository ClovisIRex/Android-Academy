package dev.tal.exercise5tal.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import dev.tal.exercise5tal.R;
import dev.tal.exercise5tal.rest.Hit;
import dev.tal.exercise5tal.rest.ImageSearchResult;
import dev.tal.exercise5tal.rest.PixabayService;
import dev.tal.exercise5tal.rest.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PixabayService service;
    private LinearLayoutManager mLinearLayoutManager;
    private ImageAdapter mImageAdapter;

    @BindView(R.id.search_edit_text) EditText mSearchEditText;
    @BindView(R.id.hits_description) TextView mTv_description;
    @BindView(R.id.recycler_view_results) RecyclerView mRecyclerView;

    @OnClick(R.id.search_button) void searchImages() {

        mTv_description.setText("Searching...");

        //get search term
        final String searchTerm = mSearchEditText.getText().toString();

        ServiceGenerator.currentPage++;


        //run request on Pixabay
        service = ServiceGenerator.retrofit.create(PixabayService.class);
        String plusSeparatedSearchTerm = TextUtils.join("+", searchTerm.split(" "));
        Call<ImageSearchResult> call = service
                .searchImage(plusSeparatedSearchTerm, ServiceGenerator.currentPage);

        call.enqueue(new Callback<ImageSearchResult>() {
            @Override
            public void onResponse (Call<ImageSearchResult> call, Response<ImageSearchResult> response) {

                // check if call went through and update the UI accordingly.
                if (response.code() == 200) {
                    mTv_description.setText(String.format(getString(R.string.hits_found), response.body().getTotalHits(),
                            mSearchEditText.getText().toString()));
                    ArrayList<Hit> hits = (ArrayList<Hit>) response.body().getHits();
                    mImageAdapter = new ImageAdapter(hits);
                    mRecyclerView.setAdapter(mImageAdapter);
                } else {
                    mTv_description.setText(String.format(getString(R.string.error_with_code), response.code()));
                }

            }

            @Override
            public void onFailure (Call<ImageSearchResult> call, Throwable t) {
                // HTTP call failed, show something to the user.
                mTv_description.setText(R.string.something_went_wrong);
            }
        });

    }

    @OnTextChanged(value = R.id.search_edit_text,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextCHanged() {
        ServiceGenerator.currentPage = 1;


    }

    private void initRecycleView() {
        mLinearLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.setAdapter(mImageAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecycleView();
    }



}
