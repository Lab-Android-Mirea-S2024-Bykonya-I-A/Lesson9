package com.example.rumireabykonyaialesson9.data.repositories;

import androidx.annotation.NonNull;

import com.example.rumireabykonyaialesson9.domain.models.Movie;
import com.example.rumireabykonyaialesson9.domain.repositories.IMovieRepository;

public class MockMovieRepository implements IMovieRepository {
    @Override
    public boolean saveMovie(@NonNull Movie movie) {
        return true;
    }
    @Override
    public Movie getMovie() {
        return new Movie(1,"Doctor Strange");
    }
}
