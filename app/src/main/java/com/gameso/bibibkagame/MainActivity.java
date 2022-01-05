package com.gameso.bibibkagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartGame = findViewById(R.id.buttonStartGame);
        Button buttonRules = findViewById(R.id.buttonRules);
        Button buttonExit = findViewById(R.id.buttonExit);
        Button[] buttons = new Button[]{buttonStartGame, buttonRules, buttonExit};
        for(Button b:buttons){
            b.setOnClickListener(onClickListener);
        }
    }

    View.OnClickListener onClickListener = view -> {
        int buttonPressed = Integer.parseInt(view.getTag().toString());
        switch (buttonPressed){
            case 0:
                Intent intentStartGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intentStartGame);
                finish();
                break;
            case 1:
                Intent intentRules = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intentRules);
                finish();
                break;
            case 2:
                finishAffinity();
                break;
        }
    };
}