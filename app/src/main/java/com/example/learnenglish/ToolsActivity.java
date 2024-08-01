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

public class ToolsActivity extends AppCompatActivity {

    private ArrayList<ImageView> toolImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tools);

        toolImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        toolImages.add(findViewById(R.id.helmet));
        toolImages.add(findViewById(R.id.mask));
        toolImages.add(findViewById(R.id.screwdriver));
        toolImages.add(findViewById(R.id.drill));
        toolImages.add(findViewById(R.id.hammer));
        toolImages.add(findViewById(R.id.knife));


        names.add("Helmet");
        names.add("Mask");
        names.add("Screwdriver");
        names.add("Hand Drill");
        names.add("Hammer");
        names.add("Knife");


        audioResIds.add(R.raw.helmet);
        audioResIds.add(R.raw.mask);
        audioResIds.add(R.raw.screwdriver);
        audioResIds.add(R.raw.handdrill);
        audioResIds.add(R.raw.hammer);
        audioResIds.add(R.raw.knife);

        for (int i = 0; i < toolImages.size(); i++) {
            final int index = i;
            toolImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(ToolsActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(ToolsActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
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