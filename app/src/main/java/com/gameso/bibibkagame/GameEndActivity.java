package com.gameso.bibibkagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameEndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        Button buttonTryAgain = findViewById(R.id.buttonTryAgain);
        Button buttonExitEnd = findViewById(R.id.buttonExitEnd);
        buttonTryAgain.setOnClickListener(onClickTryListener);
        buttonExitEnd.setOnClickListener(onClickEndListener);
    }

    View.OnClickListener onClickTryListener = view -> {
        Intent intent = new Intent(GameEndActivity.this , GameActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickEndListener = view -> {
        finishAffinity();
    };
}