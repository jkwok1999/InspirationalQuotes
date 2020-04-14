package com.example.inspirationalquotes.Entities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Interface that defines all API endpoints of the REST API service
public interface JokeService {

    //Default endpoint when getJokes() is called with no arguments
    @GET ("jokes/random?category=dev")
    Call<JokeLoreResponse> getJokes();

    //Endpoint that substitutes a query into the endpoint based on the "category" string passed in
    @GET ("jokes/random")
    Call<JokeLoreResponse> getJokes(@Query("category") String category);

}
