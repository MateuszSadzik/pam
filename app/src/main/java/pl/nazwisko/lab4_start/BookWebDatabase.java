package pl.nazwisko.lab4_start;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pl.nazwisko.lab4_start.review.Review;
import pl.nazwisko.lab4_start.review.ReviewDao;


@Database(version = 1, entities = {Review.class})

public abstract class BookWebDatabase extends RoomDatabase {

    public abstract ReviewDao reviewDao();

    private static BookWebDatabase INSTANCE;
    public static BookWebDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookWebDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookWebDatabase.class, "book_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }}

