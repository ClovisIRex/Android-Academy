package dev.tal.exercise4tal.counterasynctask;

/**
 * Created by tal on 11/26/17.
 */

public interface IAsyncTaskEvents {

    void onPreExecute();

    void onPostExecute();

    void onProgressUpdate(Integer integer);

    void onCancel();
}
