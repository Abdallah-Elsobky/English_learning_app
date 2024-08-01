package com.example.learnenglish;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    private ArrayList<ImageView> drinkImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drinks);

        drinkImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        drinkImages.add(findViewById(R.id.tea));
        drinkImages.add(findViewById(R.id.coffee));
        drinkImages.add(findViewById(R.id.latte));
        drinkImages.add(findViewById(R.id.hotchocolate));
        drinkImages.add(findViewById(R.id.lemonjuice));
        drinkImages.add(findViewById(R.id.orangejuice));
        drinkImages.add(findViewById(R.id.mangojuice));
        drinkImages.add(findViewById(R.id.blueberry));


        names.add("Tea");
        names.add("Coffee");
        names.add("Latte");
        names.add("Hot chocolate");
        names.add("Lemon juice");
        names.add("Orange juice");
        names.add("Mango juice");
        names.add("Blueberry juice");


        audioResIds.add(R.raw.tea);
        audioResIds.add(R.raw.coffee);
        audioResIds.add(R.raw.latte);
        audioResIds.add(R.raw.hotchocolate);
        audioResIds.add(R.raw.lemonjuice);
        audioResIds.add(R.raw.orangejuice);
        audioResIds.add(R.raw.mangojuice);
        audioResIds.add(R.raw.blueberryjuice);

        for (int i = 0; i < drinkImages.size(); i++) {
            final int index = i;
            drinkImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(DrinksActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(DrinksActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
                        }
                    },30);
                }
            });
        }
    }
    private void animateClick(View view){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.9f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.9f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY);
        animatorSet.setDuration(300);
        animatorSet.start();
    }
}