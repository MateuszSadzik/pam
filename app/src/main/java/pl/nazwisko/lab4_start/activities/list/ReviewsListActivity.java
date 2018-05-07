package pl.nazwisko.lab4_start.activities.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import pl.nazwisko.lab4_start.R;
import pl.nazwisko.lab4_start.review.ReviewAdapter;

/**
 * Aktywność wyświetlająca listę recenzji.
 *
 * @author Michał Ciołek
 */
public class ReviewsListActivity extends AppCompatActivity {

    private ReviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_list);

        // TODO Deklaracja i inicjalizacja ReviewModel

        // znajdź RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // utworzenie adaptera
        // zwróć uwagę, że recenzje nie są przekazywane do adaptera przez konstruktor
        // recenzje zostaną przekazane później za pomocą setReviews(...)
        mAdapter = new ReviewAdapter();

        // połączenie adaptera z RecyclerView
        recyclerView.setAdapter(mAdapter);
    }
}
