package com.bigmacdev.pharmacy_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.usernameLogin);
        password=(EditText)findViewById(R.id.passwordLogin);
        submit=(Button)findViewById(R.id.submitLogin);

        submit.setOnClickListener(submitClick);
    }

    View.OnClickListener submitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (username.getText().toString().length()<1){
                Toast.makeText(MainActivity.this, "Missing Username!", Toast.LENGTH_SHORT).show();
            } else{
                if(password.getText().toString().length()<1){
                    Toast.makeText(MainActivity.this, "Missing Password!", Toast.LENGTH_SHORT).show();
                } else{
                    if (login(username.getText().toString(), password.getText().toString())){
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        intent.setClass(MainActivity.this, Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Username or Password is Incorrect!", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                    }
                }
            }
        }
    };

    private boolean login(String u, String p){
        return true;
    }
}
