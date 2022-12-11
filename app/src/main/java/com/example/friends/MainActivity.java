package com.example.friends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<Friends_Model> friends_models = new ArrayList<>();

    int[] friendsImages = {R.drawable.rachel, R.drawable.ross, R.drawable.monica,
            R.drawable.joey, R.drawable.phoebe, R.drawable.chandler};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpFriendsModels();

        F_RecyclerViewAdapter adapter = new F_RecyclerViewAdapter(this, friends_models, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpFriendsModels()
    {
        String[] friendsNames = getResources().getStringArray(R.array.Character_name_txt);
        String[] friendsZodiac = getResources().getStringArray(R.array.Zodiac_Of_Character_txt);
        String[] friendsDescription = getResources().getStringArray(R.array.Description_Of_Character_txt);

        for(int i = 0; i < friendsNames.length; i++)
        {
            friends_models.add(new Friends_Model(friendsNames[i], friendsZodiac[i],
                    friendsImages[i], friendsDescription[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", friends_models.get(position).getName());
        intent.putExtra("ZODIAC", friends_models.get(position).getZodiac());
        intent.putExtra("DESCRIPTION", friends_models.get(position).getDescription());
        intent.putExtra("IMAGE", friends_models.get(position).getImage());

        startActivity(intent);

    }
}
