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

public class FamilyActivity extends AppCompatActivity {

    private ArrayList<ImageView> familyImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_family);

        familyImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        familyImages.add(findViewById(R.id.oldman));
        familyImages.add(findViewById(R.id.oldwoman));
        familyImages.add(findViewById(R.id.father));
        familyImages.add(findViewById(R.id.mom));
        familyImages.add(findViewById(R.id.boy));
        familyImages.add(findViewById(R.id.sister));
        familyImages.add(findViewById(R.id.baby));
        familyImages.add(findViewById(R.id.children));


        names.add("Grand Father");
        names.add("Grand Mother");
        names.add("Father");
        names.add("Mother");
        names.add("Brother");
        names.add("Sister");
        names.add("Baby");
        names.add("Children");


        audioResIds.add(R.raw.grandfather);
        audioResIds.add(R.raw.grandmother);
        audioResIds.add(R.raw.father);
        audioResIds.add(R.raw.mother);
        audioResIds.add(R.raw.brother);
        audioResIds.add(R.raw.sister);
        audioResIds.add(R.raw.baby);
        audioResIds.add(R.raw.children);

        for (int i = 0; i < familyImages.size(); i++) {
            final int index = i;
            familyImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(FamilyActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(FamilyActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
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