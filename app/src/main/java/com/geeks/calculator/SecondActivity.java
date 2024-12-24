package com.geeks.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.geeks.calculator.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private boolean isLiked = false;
ActivitySecondBinding viewBinding;
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
viewBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(viewBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getData());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        String urlImage = "https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExczN0MmdhbjNvemNqc3c1d3Y5a2V6aWxjNXM5Mjl2aThvNGNmMGJiaiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/7d0xUjdNpa9ChOY8Yf/giphy.webp";
        Glide.with(SecondActivity.this)
                .load(urlImage)
                .placeholder(R.color.dark_gray)
                .into(viewBinding.btnImg);

    }

    public void offActivities(View v) {
        finishAffinity();
    }

    public void nextActivities(View v) {
        Intent intent = new Intent(SecondActivity.this, MapsActivity.class);
        startActivity(intent);
    }

public void onCalculator(View view){
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
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