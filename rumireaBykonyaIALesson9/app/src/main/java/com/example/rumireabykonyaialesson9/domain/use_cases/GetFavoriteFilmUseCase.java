package com.example.rumireabykonyaialesson9.domain.use_cases;
import com.example.rumireabykonyaialesson9.domain.models.Movie;
import com.example.rumireabykonyaialesson9.domain.repositories.IMovieRepository;

public class GetFavoriteFilmUseCase {
    private final IMovieRepository movieRepository;

    public GetFavoriteFilmUseCase(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute() {
        return this.movieRepository.getMovie();
    }
}
