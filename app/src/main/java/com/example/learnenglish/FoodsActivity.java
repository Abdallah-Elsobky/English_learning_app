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

import java.util.ArrayList;

public class FoodsActivity extends AppCompatActivity {


    private ArrayList<ImageView> foodImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foods);

        foodImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        foodImages.add(findViewById(R.id.steak));
        foodImages.add(findViewById(R.id.chicken));
        foodImages.add(findViewById(R.id.fish));
        foodImages.add(findViewById(R.id.chrimp));
        foodImages.add(findViewById(R.id.sushi));
        foodImages.add(findViewById(R.id.pizza));
        foodImages.add(findViewById(R.id.hamburger));
        foodImages.add(findViewById(R.id.spaghettti));


        names.add("Steak");
        names.add("Chicken");
        names.add("Fish");
        names.add("Chrimp");
        names.add("Sushi");
        names.add("Pizza");
        names.add("Hamburger");
        names.add("Spaghettti");


        audioResIds.add(R.raw.steack);
        audioResIds.add(R.raw.chicken);
        audioResIds.add(R.raw.fish);
        audioResIds.add(R.raw.shrimp);
        audioResIds.add(R.raw.sushi);
        audioResIds.add(R.raw.pizza);
        audioResIds.add(R.raw.beefburger);
        audioResIds.add(R.raw.spaghetti);


        for (int i = 0; i < foodImages.size(); i++) {
            final int index = i;
            foodImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(FoodsActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(FoodsActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
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