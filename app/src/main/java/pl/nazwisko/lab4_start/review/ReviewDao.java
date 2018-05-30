package pl.nazwisko.lab4_start.review;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {
    @Insert
    public void insert(Review review);


    @Query("SELECT * FROM Review")
    public LiveData<List<Review>> getAllReviews();

}



