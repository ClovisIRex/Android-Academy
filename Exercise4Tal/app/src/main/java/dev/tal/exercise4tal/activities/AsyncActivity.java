package dev.tal.exercise4tal.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.tal.exercise4tal.R;
import dev.tal.exercise4tal.counterasynctask.CounterAsyncTask;
import dev.tal.exercise4tal.counterasynctask.IAsyncTaskEvents;

public class AsyncActivity extends AppCompatActivity implements IAsyncTaskEvents {
    private CounterAsyncTask mAsyncTask;

    @BindView(R.id.tv_async) TextView mTextView;

    @OnClick(R.id.createAsyncBtn) void createAsyncTask() {
        Toast.makeText(this, getString(R.string.msg_oncreate), Toast.LENGTH_SHORT).show();
        mAsyncTask = new CounterAsyncTask(this);

    }
    @OnClick(R.id.startAsyncBtn) void startAsyncTask() {
        startAsync(1,10);
    }
    @OnClick(R.id.cancelAsyncBtn) void cancelAsyncTask() {
        mAsyncTask.cancel(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            try {
                int start = Integer.parseInt(savedInstanceState.getString("TextViewText"));
                boolean isFinished = savedInstanceState.getBoolean("isFinishedStatus");
                savedInstanceState = null;

                if (!isFinished) {
                    mAsyncTask = new CounterAsyncTask(this);
                    startAsync(start, 10);
                }

            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onPreExecute() {
        Toast.makeText(this, getString(R.string.msg_preexecute), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecute() {
        Toast.makeText(this, getString(R.string.msg_postexecute), Toast.LENGTH_SHORT).show();
        mTextView.setText("Done!");
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        mTextView.setText(String.valueOf(integer));
    }

    @Override
    public void onCancel() {
        Toast.makeText(this, getString(R.string.msg_oncancel), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        String text = String.valueOf(mTextView.getText());
        boolean asyncTaskStatus = mAsyncTask.getStatus() == AsyncTask.Status.FINISHED ? true : false;
        Log.d("VALUE", text);
        if(!text.equals("Done!")) {
            outState.putString("TextViewText", text);
            outState.putBoolean("isFinishedStatus", asyncTaskStatus);
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        if (mAsyncTask != null) {
            mAsyncTask.cancel(false);
            mAsyncTask = null;
        }
        super.onDestroy();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AsyncActivity.class));
    }

    public void startAsync(int start, int finish) {
        if ((mAsyncTask == null) || (mAsyncTask.isCancelled())) {
            Toast.makeText(this, R.string.msg_should_create_task, Toast.LENGTH_SHORT).show();
        } else if((mAsyncTask.getStatus() == AsyncTask.Status.RUNNING)) {
            Toast.makeText(this, "Task already running", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.msg_onstart), Toast.LENGTH_SHORT).show();
            mAsyncTask.execute(start, finish);
        }
    }
}
