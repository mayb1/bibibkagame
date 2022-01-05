package com.gameso.bibibkagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Button buttonBackToMenu = findViewById(R.id.buttonBackToMenu);
        buttonBackToMenu.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(RulesActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    };
}