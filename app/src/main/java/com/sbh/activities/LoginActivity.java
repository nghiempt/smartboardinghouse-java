package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbh.R;
import com.sbh.api.APIService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextPhone;
    private EditText editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnSignIn);
        editTextPhone = (EditText) findViewById(R.id.edPhoneNumber);
        editTextPassword = (EditText) findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(editTextPhone.getText().toString().trim(), editTextPassword.getText().toString().trim());
            }
        });
    }

    private void login(String phoneNumber, String password) {
        goToOwner();
//        boolean result = false;
//        Map<String, String> map = new HashMap<>();
//        map.put("username", phoneNumber);
//        map.put("password", password);
//        APIService.apiService.login(map).enqueue(new Callback<Map<String, Object>>() {
//            @Override
//            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
//                if (response != null) {
//                    Map<String, Object> map = response.body();
//                    if (map == null) {
//                        Toast.makeText(LoginActivity.this, "Loss internet", Toast.LENGTH_SHORT).show();
//                    }
//                    if ((Boolean) map.get("result") == true) {
//                        Toast.makeText(LoginActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Loss internet", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Loss internet!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void goToOwner() {
        Intent intent = new Intent(this, ManagementActivity.class);
        startActivity(intent);
    }
}