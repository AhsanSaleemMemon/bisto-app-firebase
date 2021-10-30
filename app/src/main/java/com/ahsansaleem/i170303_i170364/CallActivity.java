package com.ahsansaleem.i170303_i170364;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CallActivity extends AppCompatActivity {
    ImageView end_call_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call2);


        end_call_btn = findViewById(R.id.end_call_btn);
        end_call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CallActivity.this, ChatScreenActivity.class));
            }
        });
    }
}