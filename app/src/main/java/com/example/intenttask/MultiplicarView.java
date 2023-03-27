package com.example.intenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultiplicarView extends AppCompatActivity {

    private Button btnGoBack;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicar_view);

        btnGoBack = findViewById(R.id.goBack);

        result = findViewById(R.id.resultOp);

        String res = getIntent().getStringExtra("res");

        result.setText(res);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicarView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}