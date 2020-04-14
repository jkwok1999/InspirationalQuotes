package com.example.inspirationalquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.inspirationalquotes.Entities.JokeLoreResponse;
import com.example.inspirationalquotes.Entities.JokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvJoke;
    private Button btnJoke;
    private Button btnCategory;
    private String joke;
    private ImageView imgChuckNorrisApproves;
    private ProgressBar progressBar;
    private static final String TAG = "MainActivity";
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Checks if an intent was passed to the MainActivity (on first run-through this is false but if the user selects a category
        //And gets redirected this condition will be true, setting the category variable to what was selected to be used when using RetroFit
        if (getIntent().getStringExtra(CategoryActivity.CATEGORY) != null) {
            category = getIntent().getStringExtra(CategoryActivity.CATEGORY);
            System.out.println(category);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set a custom title, "Inspirational Quotes"
        setTitle("Inspirational Quotes");

        //Pair the variables to the widgets in the XML File
        tvJoke = findViewById(R.id.tvJoke);
        btnJoke = findViewById(R.id.btnJoke);
        btnCategory = findViewById(R.id.btnCategory);
        imgChuckNorrisApproves = findViewById(R.id.imgChuckNorrisApproves);
        progressBar = findViewById(R.id.progressBar);
        Log.d(TAG, "Pairing with XML: Success");

        //Set particular widgets that should not be visible upon the app opening to invisible
        imgChuckNorrisApproves.setVisibility(View.INVISIBLE); //This picture should only be visible when a joke is displayed
        progressBar.setVisibility(View.INVISIBLE); //This progress bar should only be visible when RetroFit is getting data from API

        //Sets listener for the "Get Random Joke Button" to display a random joke based on the category selected
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgChuckNorrisApproves.setVisibility(View.INVISIBLE); //Sets image back to invisible when a new joke is being processed

                //Set widgets to show that the API data is being retrieved by the REST API
                tvJoke.setText("Loading...");
                progressBar.setVisibility(View.VISIBLE);

                //Create RetroFit object that sets a base URL (that will be paired with endpoints upon call), has a GSONConverterFactory
                //That automatically converts the JSON into GSON to be used in this application
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.chucknorris.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Log.d(TAG, "Retrofit Initialisation: SUCCESS");

                //Pairs retrofit with the JokeService interface and calls the getJokes() method/call
                JokeService service = retrofit.create(JokeService.class);
                Call<JokeLoreResponse> jokeCall;
                if (category != null) {
                    jokeCall = service.getJokes(category);
                } else {
                    jokeCall = service.getJokes();
                }
                Log.d(TAG, "Call: SUCCESS");
                jokeCall.enqueue(new Callback<JokeLoreResponse>() {
                    //onResponse() method that displays the joke and picture if a connection to the online API is successful
                    @Override
                    public void onResponse(Call<JokeLoreResponse> call, Response<JokeLoreResponse> response) {
                        joke = response.body().getValue();
                        tvJoke.setText(joke);
                        imgChuckNorrisApproves.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.d(TAG, "onResponse: SUCCESS");
                    }
                    //onFailure() method that logs a message if a connection to the online API is unsuccessful
                    @Override
                    public void onFailure(Call<JokeLoreResponse> call, Throwable t) {
                        Log.d(TAG, "On:Failure: FAILURE" + t.getLocalizedMessage());
                    }
                });
            }
        });

        //Sets listener for the "Change Category" Button that opens up the CategoryActivity class which allows the user to select their category
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CategoryActivity.class);
                startActivity(intent);
                Log.d(TAG, "Intent Started: SUCCESS");
            }
        });
    }
}
