package com.example.learnenglish;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageView> categoryImages;
    private ArrayList<Class<?>> activityClasses;
    private ArrayList<String> categoryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        categoryImages = new ArrayList<>();
        activityClasses = new ArrayList<>();
        categoryNames = new ArrayList<>();


        categoryImages.add(findViewById(R.id.foods));
        categoryImages.add(findViewById(R.id.drinks));
        categoryImages.add(findViewById(R.id.family));
        categoryImages.add(findViewById(R.id.animals));
        categoryImages.add(findViewById(R.id.colors));
        categoryImages.add(findViewById(R.id.footballers));
        categoryImages.add(findViewById(R.id.tools));
        categoryImages.add(findViewById(R.id.shapes));


        activityClasses.add(FoodsActivity.class);
        activityClasses.add(DrinksActivity.class);
        activityClasses.add(FamilyActivity.class);
        activityClasses.add(AnimalActivity.class);
        activityClasses.add(ColorsActivity.class);
        activityClasses.add(FootballersActivity.class);
        activityClasses.add(ToolsActivity.class);
        activityClasses.add(ShapesActivity.class);


        categoryNames.add("Foods category");
        categoryNames.add("Drinks category");
        categoryNames.add("Family members");
        categoryNames.add("Animals category");
        categoryNames.add("Colors category");
        categoryNames.add("Footballers category");
        categoryNames.add("Tools category");
        categoryNames.add("Shapes category");

        for (int i = 0; i < categoryImages.size(); i++) {
            final int index = i;
            categoryImages.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateClick(view);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, activityClasses.get(index));
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, categoryNames.get(index), Toast.LENGTH_SHORT).show();
                        }
                    }, 200);
                }
            });
        }
    }

    private void animateClick(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.9f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.9f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY);
        animatorSet.setDuration(300);
        animatorSet.start();
    }
}