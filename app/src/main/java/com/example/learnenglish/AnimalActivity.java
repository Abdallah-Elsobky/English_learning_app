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

public class AnimalActivity extends AppCompatActivity {

    private ArrayList<ImageView> animalImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animal);

        animalImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        animalImages.add(findViewById(R.id.lion));
        animalImages.add(findViewById(R.id.tiger));
        animalImages.add(findViewById(R.id.cheetah));
        animalImages.add(findViewById(R.id.zebra));
        animalImages.add(findViewById(R.id.elephant));
        animalImages.add(findViewById(R.id.anaconda));
        animalImages.add(findViewById(R.id.owl));
        animalImages.add(findViewById(R.id.parrot));

        names.add("Lion");
        names.add("Tiger");
        names.add("Cheetah");
        names.add("Zebra");
        names.add("Elephant");
        names.add("Snake");
        names.add("Owl");
        names.add("Parrot");

        audioResIds.add(R.raw.lion);
        audioResIds.add(R.raw.tiger);
        audioResIds.add(R.raw.cheetah);
        audioResIds.add(R.raw.zebra);
        audioResIds.add(R.raw.elephant);
        audioResIds.add(R.raw.snake);
        audioResIds.add(R.raw.owl);
        audioResIds.add(R.raw.parrot);

        for (int i = 0; i < animalImages.size(); i++) {
            final int index = i;
            animalImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(AnimalActivity.this, audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(AnimalActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
                        }
                    }, 30);
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
