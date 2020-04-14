package com.example.inspirationalquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    public static final String CATEGORY = "category";
    private Button btnAnimal, btnCareer, btnCelebrity, btnDev, btnExplicit, btnFashion, btnFood, btnHistory, btnMoney,
            btnMovie, btnMusic, btnPolitical, btnReligion, btnScience, btnSport, btnTravel;
    private String category;
    private static final String TAG = "CategoryActivity";

    //This activity is intended to allow the user to select their own category of jokes
    //Initially I believed that implementing many buttons would be simpler than recyclerview
    //After trying, I believe a recyclerview would be a lot easier and also a lot neater
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        setTitle("Choose your own category");

        //Pair the Button variables to the widgets in the XML File
        btnAnimal = findViewById(R.id.btnAnimal);
        btnCareer = findViewById(R.id.btnCareer);
        btnCelebrity = findViewById(R.id.btnCelebrity);
        btnDev = findViewById(R.id.btnDev);
        btnExplicit = findViewById(R.id.btnExplicit);
        btnFashion = findViewById(R.id.btnFashion);
        btnFood = findViewById(R.id.btnFood);
        btnHistory = findViewById(R.id.btnHistory);
        btnMoney = findViewById(R.id.btnMoney);
        btnMovie = findViewById(R.id.btnMovie);
        btnMusic = findViewById(R.id.btnMusic);
        btnPolitical = findViewById(R.id.btnPolitical);
        btnReligion = findViewById(R.id.btnReligion);
        btnScience = findViewById(R.id.btnScience);
        btnSport = findViewById(R.id.btnSport);
        btnTravel = findViewById(R.id.btnTravel);
        Log.d(TAG, "Pairing with XML: Success");

        //Set onClickListener for all the buttons to invoke the getCategory() method based on the button
        btnAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnAnimal);
                returnToMainActivity();
            }
        });
        btnCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnCareer);
                returnToMainActivity();
            }
        });
        btnCelebrity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnCelebrity);
                returnToMainActivity();
            }
        });
        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnDev);
                returnToMainActivity();
            }
        });
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnExplicit);
                returnToMainActivity();
            }
        });
        btnFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnFashion);
                returnToMainActivity();
            }
        });
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnFood);
                returnToMainActivity();
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnHistory);
                returnToMainActivity();
            }
        });
        btnMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnMoney);
                returnToMainActivity();
            }
        });
        btnMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnMovie);
                returnToMainActivity();
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnMusic);
                returnToMainActivity();
            }
        });
        btnPolitical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnPolitical);
                returnToMainActivity();
            }
        });
        btnReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnReligion);
                returnToMainActivity();
            }
        });
        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnScience);
                returnToMainActivity();
            }
        });
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnSport);
                returnToMainActivity();
            }
        });
        btnTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCategory(btnTravel);
                returnToMainActivity();
            }
        });

    }

    //getCategory() method takes in a button, gets the text from the button (the category) and sets the category variable to the selected category
    public void getCategory(Button button) {
        category = button.getText().toString().toLowerCase();
        //System.out.println(category);
        Log.d(TAG, "getCategory: Success - " + category);
    }

    //returnToMainActivity() method creates an intent to go back to the mainActivity, passing in the category variable that was set by the click earlier
    public void returnToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CATEGORY,category);
        startActivity(intent);
        Log.d(TAG, "returnToMainActivity: Success - " + category);
    }
}
