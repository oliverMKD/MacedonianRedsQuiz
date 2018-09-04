package com.oli.macedonianredsquiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameWon extends Activity {
    Typeface tb;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        textView = (TextView)findViewById(R.id.tekst_pobednik);
        textView.setTypeface(typeface);

    }
    public void PlayAgain(View view) {
        Intent intent = new Intent(GameWon.this, MainGameActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
