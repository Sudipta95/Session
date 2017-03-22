package com.practice.sbkd.session;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button signup,login;
    EditText name,email,pwd;
    UserSession session;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signup=(Button)findViewById(R.id.button2);
        login=(Button)findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText3);
        pwd=(EditText)findViewById(R.id.editText5);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(Register.this,MainActivity.class);
                startActivity(m);
            }
        });
    }
}
