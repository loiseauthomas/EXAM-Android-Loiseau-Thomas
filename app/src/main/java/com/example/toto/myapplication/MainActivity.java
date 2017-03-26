package com.example.toto.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search_button = (Button) findViewById(R.id.button);
        search_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage(v);
            }
        });

    }

    /** Called when the user taps the Search button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }
}
