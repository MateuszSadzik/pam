package pl.nazwisko.lab4_start.activities.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.nazwisko.lab4_start.R;
import pl.nazwisko.lab4_start.book.Book;
import pl.nazwisko.lab4_start.book.BookAdapter;

/**
 * Aktywność wyświetlająca listę książek.
 *
 * @author Michał Ciołek
 */
public class BooksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Jan Kowalski", "Szkoła programowania", new Date(112, 4, 3)));
        books.add(new Book("Michał Ciołek", "Android dla opornych", new Date(117, 1, 1)));
        books.add(new Book("Magdalena Gessler", "Kuchenne rewolucje", new Date(99, 11, 23)));
        books.add(new Book("Autor5", "Tytul5", new Date(117, 10, 10)));
        books.add(new Book("Autor6", "Tytul6", new Date(117, 10, 10)));
        books.add(new Book("Autor7", "Tytul7", new Date(117, 10, 10)));
        books.add(new Book("Autor8", "Tytul8", new Date(117, 10, 10)));
        books.add(new Book("Autor9", "Tytul9", new Date(117, 10, 10)));
        books.add(new Book("Autor10", "Tytul10", new Date(117, 10, 10)));
        books.add(new Book("Autor11", "Tytul11", new Date(117, 10, 10)));
        books.add(new Book("Autor12", "Tytul12", new Date(117, 10, 10)));


        for (Book book : books) {
            Log.d("BooksListActivity", book.toString());
        }

        // znajdź RecyclerView
        RecyclerView booksListRecyclerView = findViewById(R.id.books_list_recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        booksListRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // utworzenie adaptera wraz z książkami dodanymi do tablicy
        BookAdapter booksListAdapter = new BookAdapter(books);

        // połączenie adaptera z RecyclerView
        booksListRecyclerView.setAdapter(booksListAdapter);
    }
}
