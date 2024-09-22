package com.example.rumireabykonyaialesson9.domain.use_cases;
import com.example.rumireabykonyaialesson9.domain.models.Movie;
import com.example.rumireabykonyaialesson9.domain.repositories.IMovieRepository;

public class SaveFilmToFavoriteUseCase {
    private final IMovieRepository movieRepository;

    public SaveFilmToFavoriteUseCase(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return this.movieRepository.saveMovie(movie);
    }
}
