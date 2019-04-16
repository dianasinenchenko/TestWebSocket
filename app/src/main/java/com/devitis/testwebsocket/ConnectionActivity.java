package com.devitis.testwebsocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;


/**
 * Created by Diana on 16.04.2019.
 */

public class ConnectionActivity extends AppCompatActivity {

    private Socket socket;
    private String Mtdu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        Mtdu = (String) getIntent().getExtras().getString(MainActivity.MTDU);

        try {

            socket = IO.socket("http://...:3000");

            socket.connect();

            socket.emit("GETDATA", Mtdu);




        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //событие кл слово на сервере
        socket.on("bla bla", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String data = (String) args[0];

                        Toast.makeText(ConnectionActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}
