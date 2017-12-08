//package dev.tal.exercise4tal.activities;
//
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import dev.tal.exercise4tal.R;
//import dev.tal.exercise4tal.counterasynctask.CounterAsyncTask;
//import dev.tal.exercise4tal.counterasynctask.IAsyncTaskEvents;
//import dev.tal.exercise4tal.simpleasynctask.MyCounterSimpleAsyncTask;
//
//public class ThreadsActivity extends AppCompatActivity implements IAsyncTaskEvents {
//
//    private MyCounterSimpleAsyncTask mAsyncTask;
//
//    @BindView(R.id.tv_async)
//    TextView mTextView;
//
//    @OnClick(R.id.createAsyncBtn) void createAsyncTask() {
//        Toast.makeText(this, getString(R.string.msg_oncreate), Toast.LENGTH_SHORT).show();
//        mAsyncTask = new MyCounterSimpleAsyncTask(this);
//
//    }
//    @OnClick(R.id.startAsyncBtn) void startAsyncTask() {
//        startAsync(1,10);
//    }
//    @OnClick(R.id.cancelAsyncBtn) void cancelAsyncTask() {
//        mAsyncTask.cancel(true);
//    }
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_threads);
//        ButterKnife.bind(this);
//    }
//
//    @Override
//    public void onPreExecute() {
//
//    }
//
//    @Override
//    public void onPostExecute() {
//
//    }
//
//    @Override
//    public void onProgressUpdate(Integer integer) {
//
//    }
//
//    @Override
//    public void onCancel() {
//
//    }
//
//    private void startAsync(int start, int finish) {
//        if ((mAsyncTask == null) || (mAsyncTask.isCancelled())) {
//            Toast.makeText(this, R.string.msg_should_create_task, Toast.LENGTH_SHORT).show();
//        } else if((mAsyncTask.getStatus() == AsyncTask.Status.RUNNING)) {
//            Toast.makeText(this, "Task already running", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, getString(R.string.msg_onstart), Toast.LENGTH_SHORT).show();
//            mAsyncTask.execute(start, finish);
//        }
//    }
//}
