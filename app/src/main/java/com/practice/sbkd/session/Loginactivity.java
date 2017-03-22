package com.practice.sbkd.session;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Loginactivity extends AppCompatActivity {
    UserSession session;
    TextView tv;
    Button logout;
    String Sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        tv=(TextView)findViewById(R.id.name);
        logout= (Button) findViewById(R.id.logout);
        session=new UserSession(getApplicationContext());
        if(session.checkLogin()){
            Intent i =new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
        else{
            tv.setText("HELLO "+Sname);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.LogoutUser();
                Intent i=new Intent(Loginactivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
