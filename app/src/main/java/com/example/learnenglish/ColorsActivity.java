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

public class ColorsActivity extends AppCompatActivity {

    private ArrayList<ImageView> colorImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_colors);

        colorImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        colorImages.add(findViewById(R.id.blackcolor));
        colorImages.add(findViewById(R.id.graycolor));
        colorImages.add(findViewById(R.id.whitecolor));
        colorImages.add(findViewById(R.id.redcolor));
        colorImages.add(findViewById(R.id.purplecolor));
        colorImages.add(findViewById(R.id.pinkcolor));
        colorImages.add(findViewById(R.id.greencolor));
        colorImages.add(findViewById(R.id.bluecolor));


        names.add("Black");
        names.add("Gray");
        names.add("White");
        names.add("Red");
        names.add("Purple");
        names.add("Pink");
        names.add("Green");
        names.add("Blue");


        audioResIds.add(R.raw.black);
        audioResIds.add(R.raw.gray);
        audioResIds.add(R.raw.white);
        audioResIds.add(R.raw.red);
        audioResIds.add(R.raw.purple);
        audioResIds.add(R.raw.pink);
        audioResIds.add(R.raw.green);
        audioResIds.add(R.raw.blue);

        for (int i = 0; i < colorImages.size(); i++) {
            final int index = i;
            colorImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(ColorsActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(ColorsActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
                        }
                    },30);
                }
            });
        }
    }
    private void animateClick(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.9f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.9f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY);
        animatorSet.setDuration(200);
        animatorSet.start();
    }
}