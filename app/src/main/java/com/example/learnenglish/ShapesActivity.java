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

public class ShapesActivity extends AppCompatActivity {

    private ArrayList<ImageView> shapeImages;
    private ArrayList<Integer> audioResIds;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shapes);

        shapeImages = new ArrayList<>();
        audioResIds  = new ArrayList<>();
        names = new ArrayList<>();

        shapeImages.add(findViewById(R.id.square));
        shapeImages.add(findViewById(R.id.triangle));
        shapeImages.add(findViewById(R.id.rectangle));
        shapeImages.add(findViewById(R.id.parallelogram));
        shapeImages.add(findViewById(R.id.polygon));
        shapeImages.add(findViewById(R.id.circle));


        names.add("Square");
        names.add("Triangle");
        names.add("Rectangle");
        names.add("Parallelogram");
        names.add("Polygon");
        names.add("Circle");


        audioResIds.add(R.raw.square);
        audioResIds.add(R.raw.triangle);
        audioResIds.add(R.raw.rectangle);
        audioResIds.add(R.raw.parallelogram);
        audioResIds.add(R.raw.polygon);
        audioResIds.add(R.raw.circle);

        for (int i = 0; i < shapeImages.size(); i++) {
            final int index = i;
            shapeImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayer mp3 = MediaPlayer.create(ShapesActivity.this,audioResIds.get(index));
                            mp3.start();
                            Toast.makeText(ShapesActivity.this, names.get(index), Toast.LENGTH_SHORT).show();
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