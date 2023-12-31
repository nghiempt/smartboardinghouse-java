package com.sbh.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.sbh.R;
import com.squareup.picasso.Picasso;

public class TransactionActivity extends AppCompatActivity {

    CardView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        ImageView imageView = findViewById(R.id.myImageView);

        String imageUrl = "https://ddireal.vn/kien-thuc/wp-content/uploads/2022/10/co-can-ky-hop-dong-thue-nha-tro-khong_634c3124d387d.png";

        Picasso.get()
                .load(imageUrl)
                .into(imageView);
        back = findViewById(R.id.btnBackToManagement);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}