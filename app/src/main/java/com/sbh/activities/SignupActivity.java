package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sbh.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignupActivity extends AppCompatActivity {
    private TextView txtViewSignIn;
    private EditText edFullname;
    private EditText edPhoneNumber;
    private EditText edBirthday;
    private EditText edPassword;
    private EditText edRetype;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtViewSignIn = (TextView) findViewById(R.id.txtViewSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        edFullname = (EditText) findViewById(R.id.edFullname);
        edPhoneNumber = (EditText) findViewById(R.id.edPhoneNumber);
        edBirthday = (EditText) findViewById(R.id.edBirthday);
        edPassword = (EditText) findViewById(R.id.edPassword);
        edRetype = (EditText) findViewById(R.id.edRetype);

        txtViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignIn();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signUp() {
        String fullName = edFullname.getText().toString().trim();
        String phoneNumber = edPhoneNumber.getText().toString().trim();
        String birthday = edBirthday.getText().toString().trim();
        String password = edPassword.getText().toString().trim();
        String retype = edRetype.getText().toString().trim();
        if (checkEmpty(fullName, phoneNumber, birthday, password, retype)) {
            if (isValidBirthday(birthday)) {
                if (password.equals(retype)) {
                    if (phoneNumber.matches("0[1-9]\\d{8}")) {
                        callAPISignUp();
                        Toast.makeText(SignupActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignupActivity.this, "Phone number is invalid!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Password and retype password not correct!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(SignupActivity.this, "Birthday is invalid, must follow yyyy/MM/dd", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignupActivity.this, "All input can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    private void callAPISignUp() {

    }

    public void goToSignIn() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public boolean isValidBirthday(String birthdayString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false); // Set lenient to false for strict date parsing

        try {
            Date birthday = dateFormat.parse(birthdayString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthday);
            int month = calendar.get(Calendar.MONTH) + 1; // Adding 1 because months are zero-based
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean checkEmpty(String str1, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return false;
        }
        return true;
    }
}