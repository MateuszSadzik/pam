package pl.nazwisko.lab4_start.review;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import pl.nazwisko.lab4_start.BookWebDatabase;

public class ReviewRepository {

    BookWebDatabase database;
    ReviewDao reviewDao;

    private LiveData<List<Review>> allReviews;

    public LiveData<List<Review>> getAllReviews() {

        return allReviews;
    }



    // TODO 2. Deklaracja DAO

    ReviewRepository(@NonNull Application application) {

        // TODO 1.  Deklaracja i inicjalizacja bazy danych

        database = BookWebDatabase.getDatabase(application);
        reviewDao = database.reviewDao();

        // TODO 3. Inicjalizacja DAO

        reviewDao=database.reviewDao();
        allReviews=reviewDao.getAllReviews();
    }

    public void insert(final Review word) {
        new Thread(new Runnable() {
            public void run() {
                reviewDao.insert(word);
            }
        }).start();
    }

    // TODO 4. metody (np. insert, delete, itp.)

}