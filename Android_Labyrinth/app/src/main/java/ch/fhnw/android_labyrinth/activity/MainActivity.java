package ch.fhnw.android_labyrinth.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Toast;

import ch.fhnw.android_labyrinth.view.ClickView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String ip;
    private String port;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final ClickView view = new ClickView(this);
        view.setDisplayMetrics(displayMetrics);
        setContentView(view);


        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ip = extras.getString(ConnectActivity.EXTRA_IP_ADDRESS);
            port = extras.getString(ConnectActivity.EXTRA_IP_PORT);

            connectToMachine();
        }
    }

    private void connectToMachine() {
        new ServerConnector().execute();

    }

    private class ServerConnector extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
                // 20 % failure rate
                return Math.random() < 0.8;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean successful) {
            super.onPostExecute(successful);
            if (!successful) {
                Toast toast = Toast.makeText(getApplicationContext(), "Could not connect to server", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Connection successful", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
