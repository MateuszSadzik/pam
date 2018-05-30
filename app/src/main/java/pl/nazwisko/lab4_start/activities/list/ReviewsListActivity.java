package pl.nazwisko.lab4_start.activities.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import pl.nazwisko.lab4_start.R;
import pl.nazwisko.lab4_start.review.Review;
import pl.nazwisko.lab4_start.review.ReviewAdapter;
import pl.nazwisko.lab4_start.review.ReviewViewModel;

/**
 * Aktywność wyświetlająca listę recenzji.
 *
 * @author Michał Ciołek
 */
public class ReviewsListActivity extends AppCompatActivity {

    private ReviewAdapter mAdapter;
    ReviewViewModel reviewViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_list);

        // TODO Deklaracja i inicjalizacja ReviewModel
        reviewViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);

        // znajdź RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* zle nie dokonczone

        final Observer<List<Review>> nameObserver = new Observer<List<Review>>() {
            @Override
            public void onChanged(@Nullable final String newName) {

                ReviewAdapter.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);*/


        // utworzenie adaptera
        // zwróć uwagę, że recenzje nie są przekazywane do adaptera przez konstruktor
        // recenzje zostaną przekazane później za pomocą setReviews(...)
        mAdapter = new ReviewAdapter();

        // połączenie adaptera z RecyclerView
        recyclerView.setAdapter(mAdapter);
    }
}
