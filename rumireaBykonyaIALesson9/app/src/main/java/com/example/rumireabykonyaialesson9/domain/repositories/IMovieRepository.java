package com.example.rumireabykonyaialesson9.domain.repositories;

import androidx.annotation.NonNull;

import com.example.rumireabykonyaialesson9.domain.models.Movie;

public interface IMovieRepository {
    boolean saveMovie(@NonNull Movie movie);
    Movie getMovie();
}
