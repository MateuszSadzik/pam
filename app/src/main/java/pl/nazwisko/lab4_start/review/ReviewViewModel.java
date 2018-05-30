package pl.nazwisko.lab4_start.review;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import pl.nazwisko.lab4_start.BookWebDatabase;

public class ReviewViewModel extends AndroidViewModel {

    private ReviewRepository mRepository;
    BookWebDatabase database;
    ReviewDao reviewDao;

    public LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }

    private LiveData<List<Review>> allReviews;


    public ReviewViewModel(@NonNull Application application) {
        super(application);

        mRepository = new ReviewRepository(application);
        database = BookWebDatabase.getDatabase(application);
        reviewDao = database.reviewDao();
        allReviews=mRepository.getAllReviews();
    }

        public void insert(final Review word) {
            new Thread(new Runnable() {
                public void run() {
                    reviewDao.insert(word);
                }
            }).start();
        }

    }

