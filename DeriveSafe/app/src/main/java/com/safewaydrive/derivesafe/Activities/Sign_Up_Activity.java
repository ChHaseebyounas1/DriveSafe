package com.safewaydrive.derivesafe.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.safewaydrive.derivesafe.R;
import com.victor.loading.rotate.RotateLoading;

public class Sign_Up_Activity extends AppCompatActivity {

    Button signUpBtn;
    EditText Firstname, Secondname, EnterPassword, ConfirmPassword, EnterAddress, EnterPhoneNumber, EnterMail;
    TextView alreadylogin;
    RotateLoading loading;

    String firstname, entermail, secondname, enterpassword, enterconfirmpassword, enterphonenumber, enteraddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);
        signUpBtn = findViewById(R.id.signup_btn);
        Firstname = findViewById(R.id.Firstname_ET);
        Secondname = findViewById(R.id.Secondname_ET);
        EnterMail = findViewById(R.id.Mail_ET);
        EnterPassword = findViewById(R.id.Password_ET);
        ConfirmPassword = findViewById(R.id.ConfirmPassword_ET);
        EnterPhoneNumber = findViewById(R.id.Phonenumber_ET);
        EnterAddress = findViewById(R.id.Address_ET);
        loading = findViewById(R.id.loader);
        signUpBtn = findViewById(R.id.signup_btn);

        getSupportActionBar().hide();

        alreadylogin=findViewById(R.id.AlreadyLogin);
        alreadylogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_Up_Activity.this, MainActivity.class));
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                getStrings();
                registerUser();

            }

        });

        }


    private void registerUser() {
        if (firstname.isEmpty()) {
                    Firstname.setError("Enter First name");
                    Firstname.requestFocus();
                } else if (secondname.isEmpty()) {
                    Secondname.setError("Enter second name");
                    Secondname.requestFocus();
                } else if (entermail.isEmpty()) {
                    EnterMail.setError("Enter Mail");
                    EnterMail.requestFocus();
                } else if (enterpassword.isEmpty()) {
                    EnterPassword.setError("Enter Password");
                    EnterPassword.requestFocus();
                } else if (enterconfirmpassword.isEmpty()) {
                    ConfirmPassword.setError("Enter Confirm Password");
                    ConfirmPassword.requestFocus();
                } else if (enterphonenumber.isEmpty() ) {
                    EnterPhoneNumber.setError("Enter Phone Number");
                    EnterPhoneNumber.requestFocus();
                }
             else if (enterphonenumber.length()<11) {
                EnterPhoneNumber.setError("Enter Valid Phone Number");
                EnterPhoneNumber.requestFocus();
            }
                else if (enteraddress.isEmpty()) {
                    EnterAddress.setError("Enter Address");
                    EnterAddress.requestFocus();
                } else {
                    loading.setVisibility(View.VISIBLE);
                    loading.start();
                    registerUser();
                }

    }


    private void getStrings() {
        firstname = Firstname.getText().toString();
        secondname = Secondname.getText().toString();
        entermail = EnterMail.getText().toString().trim();
        enterpassword = EnterPassword.getText().toString();
        enterconfirmpassword = ConfirmPassword.getText().toString().trim();
        enterphonenumber = EnterPhoneNumber.getText().toString().trim();
        enteraddress = EnterAddress.getText().toString().trim();
    }



    }