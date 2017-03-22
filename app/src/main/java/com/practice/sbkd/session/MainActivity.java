package com.practice.sbkd.session;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    UserSession session;
    EditText name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.button5);
        signup=(Button)findViewById(R.id.button6);
        name=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        session =new UserSession(getApplicationContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=name.getText().toString();
                String passwd=pass.getText().toString();
                session.createUserLoginSession(uname,passwd);
                Intent i= new Intent(getApplicationContext(),Loginactivity.class);
                startActivity(i);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });

    }
}
