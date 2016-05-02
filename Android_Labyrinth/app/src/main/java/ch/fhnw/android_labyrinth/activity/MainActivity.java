package ch.fhnw.android_labyrinth.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import ch.fhnw.android_labyrinth.R;
import ch.fhnw.android_labyrinth.view.ClickView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String ip;
    private String port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        setContentView(new ClickView(this, displayMetrics));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ip = extras.getString(ConnectActivity.EXTRA_IP_ADDRESS);
            port = extras.getString(ConnectActivity.EXTRA_IP_PORT);

            connectToMachine();
        }
    }

    private void connectToMachine() {
        // TODO AsyncTask<> ...
    }


}
