package dev.tal.exercise4tal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.tal.exercise4tal.R;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.asyncTaskActivityBtn) void startAsyncActivity() {
        AsyncActivity.start(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
