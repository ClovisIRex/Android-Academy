package dev.tal.exercise4tal.simpleasynctask;

/**
 * Created by tal on 11/27/17.
 */

public abstract class SimpleAsyncTask<Param> {

    protected volatile boolean mCancelled = false;

    /**
     * Runs on the UI thread before {@link #doInBackground}.
     */
    protected abstract void onPreExecute();

    /**
     * Runs on new thread after {@link #onPostExecute()} and before {@link #onPostExecute()}.
     */
    protected abstract Param doInBackground();

    /**
     * Runs on the UI thread after {@link #doInBackground}
     */
    protected abstract void onPostExecute();

    /**
     * Execute Async Task
     */
    protected abstract void execute();

    protected void onProgressUpdate(Param... values) {
    }

    protected abstract void publishProgress(Param... values);

    /**
     * cancel current task
     */
    public abstract void cancel();

    public boolean isCancelled() {
        return mCancelled;
    }
}
