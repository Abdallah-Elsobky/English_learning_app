package com.example.learnenglish;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class FootballersActivity extends AppCompatActivity {

    private ArrayList<ImageView> playerImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;
    private Button sui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_footballers);

        playerImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        playerImages.add(findViewById(R.id.ronaldo));
        playerImages.add(findViewById(R.id.messi));
        playerImages.add(findViewById(R.id.ronaldinho));
        playerImages.add(findViewById(R.id.neymar));
        playerImages.add(findViewById(R.id.mbappe));
        playerImages.add(findViewById(R.id.marcelo));
        sui = findViewById(R.id.suiii);

        names.add("Cristiano Ronaldo");
        names.add("Messi");
        names.add("Ronaldinho");
        names.add("Neymar");
        names.add("Mbappe");
        names.add("Marcelo");
        names.add("Suiiii");


        audioResIds.add(R.raw.cristianoronaldo);
        audioResIds.add(R.raw.camerawowo);
        audioResIds.add(R.raw.ronaldinho);
        audioResIds.add(R.raw.neymar);
        audioResIds.add(R.raw.mbappe);
        audioResIds.add(R.raw.marcelo);
        audioResIds.add(R.raw.crsuii);

        for (int i = 0; i < playerImages.size(); i++) {
            final int index = i;
            playerImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(FootballersActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(FootballersActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
                        }
                    },30);
                }
            });
        }
        sui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(view);
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer mp3 = MediaPlayer.create(FootballersActivity.this,audioResIds.get(6));
                        mp3.start();
                        Toast.makeText(FootballersActivity.this, names.get(6), Toast.LENGTH_SHORT).show();
                    }
                },30);
            }
        });
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
