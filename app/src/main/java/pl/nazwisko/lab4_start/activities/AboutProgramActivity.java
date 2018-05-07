package pl.nazwisko.lab4_start.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.nazwisko.lab4_start.R;

/**
 * Podstawowe informacje o aplikacji.
 *
 * @author Michał Ciołek
 */
public class AboutProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_program);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Naciśnięcie strzałki w ActionBar
        onBackPressed();
        return true;
    }
}
