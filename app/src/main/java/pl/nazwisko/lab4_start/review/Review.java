package pl.nazwisko.lab4_start.review;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Recenzja
 *
 * @author Michał Ciołek
 */
@Entity

public class Review {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String author;
    public String title;
    public String text;
}
