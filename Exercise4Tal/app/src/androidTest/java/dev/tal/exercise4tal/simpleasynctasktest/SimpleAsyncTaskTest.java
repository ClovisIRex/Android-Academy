package dev.tal.exercise4tal.simpleasynctasktest;

import android.os.Looper;

import org.junit.Test;

import dev.tal.exercise4tal.simpleasynctask.MySimpleAsyncTask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tal on 11/28/17.
 */

public class SimpleAsyncTaskTest {
    int counter = 0;

    @Test
    public void execute() throws Exception {
        new MySimpleAsyncTask() {
            @Override
            public void onPreExecute() {
                assertTrue(isOnUiThread());
                assertEquals(counter++, 0);
            }

            @Override
            public Object doInBackground() {
                assertFalse(isOnUiThread());
                assertEquals(counter++, 1);
                return new Object();
            }

            @Override
            public void onPostExecute() {
                assertTrue(isOnUiThread());
                assertEquals(counter++, 2);
            }
        }.execute();
    }

    public boolean isOnUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
