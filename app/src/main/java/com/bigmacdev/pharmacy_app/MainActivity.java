package com.bigmacdev.pharmacy_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=(Button)findViewById(R.id.submitLogin);

        submit.setOnClickListener(submitClick);
    }

    View.OnClickListener submitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Menu.class);
            startActivity(intent);
        }
    };
}
