package dev.tal.exercise4tal.simpleasynctask;

import android.os.SystemClock;

import dev.tal.exercise4tal.counterasynctask.IAsyncTaskEvents;

/**
 * Created by tal on 11/28/17.
 */

public class MyCounterSimpleAsyncTask extends MySimpleAsyncTask<Integer> {
    private IAsyncTaskEvents mIAsyncTaskEvents;

    public MyCounterSimpleAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        this.mIAsyncTaskEvents = iAsyncTaskEvents;
    }

    @Override
    public Integer doInBackground() {
        int end = 10;
        for (int i = 0; i <= end; i++) {
            if(isCancelled()) {
                return i;
            }
            publishProgress(i);
            SystemClock.sleep(500);
        }

        return end;
    }

    @Override
    public void onPreExecute() {
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onPreExecute();
        }
    }

    @Override
    public void onPostExecute() {
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onPostExecute();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if (mIAsyncTaskEvents != null) {
            mIAsyncTaskEvents.onProgressUpdate(values[0]);
        }
    }

}
