package com.example.futballive;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesEndpoint {
    @GET("football/?met=Livescore&APIkey=10716dee84bd847d0214d9211e811f7d876ef643860f4fd085b8e5bfbe818b42")
    Call<List<Match>> getMatches();
}