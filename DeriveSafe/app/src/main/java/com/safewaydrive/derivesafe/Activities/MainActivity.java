package com.safewaydrive.derivesafe.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.safewaydrive.derivesafe.R;
import com.victor.loading.rotate.RotateLoading;

public class MainActivity extends AppCompatActivity {

    private EditText Usermail,UserPassword;
    Button Login_btn;
    TextView registration;
    RotateLoading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usermail=findViewById(R.id.entermail_login_ET);
        loading=findViewById(R.id.rotateloading);
        registration=findViewById(R.id.registration);

        getSupportActionBar().hide();
        UserPassword=findViewById(R.id.enterpassword_login_ET);
        Login_btn=findViewById(R.id.login_btn);

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Sign_Up_Activity.class));
            }
        });

    }

    private  void SignIn()
    {
        String mail=Usermail.getText().toString();
        String password=UserPassword.getText().toString();

        if (mail.isEmpty())
        {
            Usermail.setError("please enter mail");
            Usermail.requestFocus();
            return;
        }
        if (password.isEmpty())
        {
            UserPassword.setError("please enter mail");
            UserPassword.requestFocus();
            return;
        }
        loading.setVisibility(View.VISIBLE);
        Intent mintent=new Intent(MainActivity.this,Navbar_Activity.class);
        startActivity(mintent);
        loading.start();
        loading.stop();
    }

}
