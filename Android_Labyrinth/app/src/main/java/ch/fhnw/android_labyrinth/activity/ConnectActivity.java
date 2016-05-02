package ch.fhnw.android_labyrinth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import ch.fhnw.android_labyrinth.R;
import ch.fhnw.android_labyrinth.activity.MainActivity;

public class ConnectActivity extends AppCompatActivity {

    public static final String EXTRA_IP_ADDRESS = "EXTRA_IP_ADDRESS";
    public static final String EXTRA_IP_PORT = "EXTRA_IP_PORT";

    private static final String DEFAULT_IP = "10.0.2.2";
    private static final String DEFAULT_PORT = "12002";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void onButtonClick (View v) {

        EditText ip = (EditText) findViewById(R.id.editIP);
        EditText port = (EditText) findViewById(R.id.editPort);



        // call activity using an explicit intent
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_IP_ADDRESS, ip != null ? "" + ip.getText() : DEFAULT_IP);
        intent.putExtra(EXTRA_IP_PORT, port != null ? "" + port.getText() : DEFAULT_PORT);

        startActivity(intent);
    }

}
