package com.example.rumireabykonyaialesson9.data.repositories;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.rumireabykonyaialesson9.domain.models.Movie;
import com.example.rumireabykonyaialesson9.domain.repositories.IMovieRepository;

public class LocalSharedPreferencesMovieRepository implements IMovieRepository {
    private SharedPreferences sharedPreferences = null;
    public LocalSharedPreferencesMovieRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }


    @Override
    public boolean saveMovie(@NonNull Movie movie) {
        return sharedPreferences.edit()
            .putString("FAVOURITE_MOVIE_TITLE", movie.getName())
            .putInt("FAVOURITE_MOVIE_ID", movie.getId())
            .commit();
    }
    @Override
    public Movie getMovie() {
        return new Movie(
            sharedPreferences.getInt("FAVOURITE_MOVIE_ID", 0),
            sharedPreferences.getString("FAVOURITE_MOVIE_TITLE", null)
        );
    }
}
