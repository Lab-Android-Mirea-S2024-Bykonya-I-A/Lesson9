package com.example.rumireabykonyaialesson9;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rumireabykonyaialesson9.data.repositories.LocalSharedPreferencesMovieRepository;
import com.example.rumireabykonyaialesson9.data.repositories.MockMovieRepository;
import com.example.rumireabykonyaialesson9.domain.models.Movie;
import com.example.rumireabykonyaialesson9.domain.repositories.IMovieRepository;
import com.example.rumireabykonyaialesson9.domain.use_cases.GetFavoriteFilmUseCase;
import com.example.rumireabykonyaialesson9.domain.use_cases.SaveFilmToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ====================================================================================
        final IMovieRepository movieRepository = new LocalSharedPreferencesMovieRepository(getSharedPreferences("FAVOURITE_FILM", Context.MODE_PRIVATE));
        getSharedPreferences("", Context.MODE_PRIVATE).getString("", "");
        // ====================================================================================
        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);
        findViewById(R.id.buttonSaveMovie).setOnClickListener(view -> {
            Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
            textView.setText(String.format("Save result %s", result));
        });
        findViewById(R.id.buttonGetMovie).setOnClickListener(view -> {
            Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
            textView.setText(String.format("Save result %s", movie.getName()));
        });
    }
}