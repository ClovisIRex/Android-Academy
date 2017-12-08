package dev.tal.exercise4tal.simpleasynctask;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by tal on 11/27/17.
 */

public class MySimpleAsyncTask<Param> extends SimpleAsyncTask<Param> {

    private Thread mBackgroundThread;

    @Override
    public void onPreExecute() {

    }

    @Override
    public Param doInBackground() {

        return null;
    }

    @Override
    public void execute() {
        runOnUIThread(new Runnable() {
            @Override
            public void run() {
                onPreExecute();
                mBackgroundThread = new Thread("Handler_executor_thread") {
                    @Override
                    public void run() {
                        doInBackground();
                        runOnUIThread(new Runnable() {
                            @Override
                            public void run() {
                                onPostExecute();
                            }
                        });
                    }
                };
                mBackgroundThread.start();
            }
        });


    }

    @Override
    public void onPostExecute() {

    }



    @Override
    protected void publishProgress(final Param ... values) {
        runOnUIThread(new Runnable() {
            @Override
            public void run() {
                onProgressUpdate(values);
            }
        });

    }

    @Override
    public void cancel() {
        mCancelled = true;
        if (mBackgroundThread != null) {
            mBackgroundThread.interrupt();
        }
    }

    private void runOnUIThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

}
