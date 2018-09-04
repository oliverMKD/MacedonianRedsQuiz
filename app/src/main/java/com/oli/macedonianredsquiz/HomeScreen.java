package com.oli.macedonianredsquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class HomeScreen extends AppCompatActivity {

    Button playGame,quit;
    TextView tQ;
    ImageView slika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        playGame =(Button)findViewById(R.id.playGame);
        quit = (Button) findViewById(R.id.quit);
        tQ = (TextView)findViewById(R.id.tQ);
        slika = (ImageView)findViewById(R.id.logoLiv);
        //PlayGame button - it will take you to the MainGameActivity
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,MainGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Quit button - This will quit the game
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        slika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //Typeface - this is for fonts style
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        playGame.setTypeface(typeface);
        quit.setTypeface(typeface);
        tQ.setTypeface(typeface);
    }
    }

