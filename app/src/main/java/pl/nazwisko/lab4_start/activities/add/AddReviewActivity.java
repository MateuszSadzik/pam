package pl.nazwisko.lab4_start.activities.add;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pl.nazwisko.lab4_start.R;
import pl.nazwisko.lab4_start.review.Review;
import pl.nazwisko.lab4_start.review.ReviewViewModel;

/**
 * Aktywność dodająca nową recenzję.
 *
 * @author Michał Ciołek
 */
public class AddReviewActivity extends AppCompatActivity {

    ReviewViewModel reviewViewModel;

        // TODO Deklaracja ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_review);

        reviewViewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);

        // TODO Inicjalizacja ViewModel
    }

    /**
     * Akcja dodania nowej recenzji wywoływana przez przycisk.
     *
     * @param view
     */

    EditText author;
    EditText title;
    EditText text;

    public void addReview(View view) {
        //1. odwołanie do widgetów
        //TODO dokończyć

        author = findViewById(R.id.author);
        title = findViewById(R.id.title);
        text = findViewById(R.id.text);

        //2. weryfikacja zawartości pól tekstowych
        //TODO dokończyć

        //3. utworzenie nowej recenzji
        //TODO dokończyć

        Review review = new Review();
        review.author = author.getText().toString();
        review.title = title.getText().toString();
        review.text = text.getText().toString();

        //4. zapisanie do bazy danych nowej recenzji (za pomocą ViewModel)
        //TODO dokończyć

        reviewViewModel.insert(review);
        //5. wyświetlenie Toast
        //TODO dokończyć

        Context context = getApplicationContext();
        CharSequence text = "Recenzja została dodana!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
