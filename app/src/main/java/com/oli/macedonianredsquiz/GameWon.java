package com.oli.macedonianredsquiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWon extends Activity {
    Typeface tb;
    TextView textView;
    TextView textViewLink;
    Button kopce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        textView = (TextView)findViewById(R.id.tekst_pobednik);
        textViewLink = (TextView)findViewById(R.id.tekst_link_macreds);
        kopce = (Button)findViewById(R.id.platygaianbutton);
        kopce.setTypeface(typeface);
        textView.setTypeface(typeface);
        textViewLink.setTypeface(typeface);
        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.macedonianreds.com"));
                startActivity(intent);
            }
        });

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
