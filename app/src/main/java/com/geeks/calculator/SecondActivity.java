package com.geeks.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private boolean isLiked = false;

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("Car");
        data.add("Plane");
        data.add("Train");
        data.add("Helicopter");
        return data;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getData());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);




    }

    public void offActivities(View v) {
        finishAffinity();
    }

    public void onLike(View view) {
        isLiked = !isLiked;
        ImageButton likeButton = findViewById(R.id.btn_like);
        if (isLiked) {
            likeButton.setBackgroundResource(R.drawable.vector__stroke_);
        } else {
            likeButton.setBackgroundResource(R.drawable.vektor_stroke_2);
        }
    }


}