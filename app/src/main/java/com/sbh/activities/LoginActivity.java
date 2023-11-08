package com.sbh.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.sbh.R;
import com.sbh.adapter.ChooseHouseAdapter;
import com.sbh.api.APIService;
import com.sbh.response.ListHouseResponse;
import com.sbh.response.ResponseObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private EditText editPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnSignIn);
        editTextPhone = (EditText) findViewById(R.id.edPhoneNumber);
        editPassword = (EditText) findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> payload = new HashMap<>();
                payload.put("username", editTextPhone.getText().toString().trim());
                payload.put("password", editPassword.getText().toString().trim());
//                login(payload);
                goToMember();
            }
        });
    }

    private void login(Map<String, String> payload) {
        APIService.apiService._signIn(payload).enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                System.out.println("================= SUCCESS =================");
                if(response.body() != null && response.body().getData() != null) {
                    // Assuming getData() returns a Map
                    Map<String, Object> data = (Map<String, Object>) response.body().getData();

                    // Retrieve role and account_ID
                    double roleDouble = (double) data.get("role");
                    double accountIdDouble = (double) data.get("account_ID");
                    int accountId = (int) accountIdDouble;
                    int role = (int) roleDouble;

                    System.out.println("Role: " + role);
                    System.out.println("Account ID: " + accountId);

                    if (role == 1) {
                        goToOwner();
                    } else {
                        goToMember();
                    }
                    System.out.println(response.body().getData());

                    System.out.println("===========================================");

                    // Save account_ID to SharedPreferences
//                    SharedPreferences sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("account_ID", accountId);
//                    editor.apply();
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                System.out.println("================= ERROR =================");
                t.printStackTrace();
                System.out.println("=========================================");
            }
        });
    }

    public void goToOwner() {
        Intent intent = new Intent(this, ListRoomActivity.class);
        startActivity(intent);
    }

    public void goToMember() {
        Intent intent = new Intent(this, ListRoomActivity.class);
        startActivity(intent);
    }
}