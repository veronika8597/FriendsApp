package com.example.friends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        String zodiac = getIntent().getStringExtra("ZODIAC");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView nameTextView = findViewById(R.id.F_Title);
        TextView zodiacTextView = findViewById(R.id.F_Title_Zodiac);
        TextView descriptionTextView = findViewById(R.id.F_Description);
        ImageView F_image = findViewById(R.id.F_Image);

        nameTextView.setText(name);
        zodiacTextView.setText(zodiac);
        descriptionTextView.setText(description);
        F_image.setImageResource(image);
    }
}