package pl.nazwisko.lab4_start.activities.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.nazwisko.lab4_start.R;
import pl.nazwisko.lab4_start.comment.Comment;
import pl.nazwisko.lab4_start.comment.CommentAdapter;

import static pl.nazwisko.lab4_start.activities.add.AddCommentActivity.COMMENTS_FILE;

/**
 * Aktywność wyświetlająca listę komentarzy.
 *
 * @author Michał Ciołek
 */
public class CommentsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_list);

        List<Comment> comments = new ArrayList<>();

        try {
            File file = new File(getFilesDir(), COMMENTS_FILE);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;

            while ((str = in.readLine()) != null) {
                comments.add(new Comment(str));
                Log.d("komentarz: ", str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // znajdź RecyclerView
        RecyclerView commentListRecyclerView = findViewById(R.id.comments_list_recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        commentListRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // utworzenie adaptera wraz z komentarzami odczytanymi z pliku
        CommentAdapter commentsListAdapter = new CommentAdapter(comments);

        // połączenie adaptera z RecyclerView
        commentListRecyclerView.setAdapter(commentsListAdapter);
    }
}
