package com.sbh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.sbh.R;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnSignIn);
        editTextPhone = (EditText) findViewById(R.id.edPhoneNumber);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextPhone.getText().toString().trim().equals("1")) {
                    login("1", "");
                } else {
                    login("2", "");
                }
            }
        });
    }

    private void login(String phoneNumber, String password) {
        if (Objects.equals(phoneNumber, "1")) {
            goToOwner();
        } else {
            goToMember();
        }
    }

    public void goToOwner() {
        Intent intent = new Intent(this, ChooseHouseActivity.class);
        startActivity(intent);
    }

    public void goToMember() {
        Intent intent = new Intent(this, ListRoomActivity.class);
        startActivity(intent);
    }
}