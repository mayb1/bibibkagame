package com.gameso.bibibkagame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class GameActivity extends AppCompatActivity {
    private boolean death;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button buttonBackToMain = findViewById(R.id.buttonBackToMain);
        Button buttonGoToRules = findViewById(R.id.buttonGoToRules);
        Button buttonExit = findViewById(R.id.buttonExit);
        Button[] buttons = new Button[]{buttonBackToMain, buttonGoToRules, buttonExit};
        for (Button b : buttons) {
            b.setOnClickListener(onClickButtonListener);
        }

        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView imageView7 = findViewById(R.id.imageView7);
        ImageView imageView8 = findViewById(R.id.imageView8);
        ImageView[] cards = new ImageView[]{imageView3, imageView4, imageView5, imageView6, imageView7, imageView8};
        for(ImageView card : cards){
            card.setOnClickListener(onClickCardListener);
            String cardName = getResources().getResourceEntryName(card.getId());
            card.setTag(cardName);
        }
    }

    View.OnClickListener onClickButtonListener = view -> {
        int buttonPressed = Integer.parseInt(view.getTag().toString());
        switch (buttonPressed){
            case 5:
                Intent intentStartGame = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intentStartGame);
                finish();
                break;
            case 3:
                Intent intentRules = new Intent(GameActivity.this, RulesActivity.class);
                startActivity(intentRules);
                finish();
                break;
            case 4:
                finishAffinity();
                break;
        }
    };

    private int getRandomGem(){
        int gemId;
        if (Math.random() > 0.5) {
            gemId = R.drawable.red_gem;
            death = true;
        } else {
            gemId = R.drawable.green_gem;
            death = false;
        }
        return gemId;
    }

    View.OnClickListener onClickCardListener = view -> {
        ImageView clickedView = (ImageView) view;
        clickedView.setImageResource(getRandomGem());
        if(death){
            Intent intent = new Intent(GameActivity.this, GameEndActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(GameActivity.this, "Great! Do it again!", Toast.LENGTH_SHORT).show();
        }
    };
}