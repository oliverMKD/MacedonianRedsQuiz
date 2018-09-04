package com.oli.macedonianredsquiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayAgain extends Activity {

    Button playAgain;
    TextView wrongAnsText;
    ImageView slika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);
        playAgain = (Button) findViewById(R.id.playAgainButton);
        wrongAnsText = (TextView)findViewById(R.id.wrongAns);
        slika = (ImageView)findViewById(R.id.slika_greska);

        slika.setImageResource(R.drawable.red_card_new);

        //play again button onclick listener
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayAgain.this, MainGameActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Setting typefaces for textview and button - this will give stylish fonts on textview and button
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        playAgain.setTypeface(typeface);
        wrongAnsText.setTypeface(typeface);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
