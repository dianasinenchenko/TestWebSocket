package com.devitis.testwebsocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button connection;
    private EditText mtdu;
    public static final String MTDU = "mtdu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection = (Button) findViewById(R.id.connection);
        mtdu = (EditText) findViewById(R.id.mtdu);

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mtdu.getText().toString().isEmpty()) {

                    Intent intent = new Intent(MainActivity.this, ConnectionActivity.class);
                    intent.putExtra(MTDU, mtdu.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
