package pl.nazwisko.lab4_start.activities.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import pl.nazwisko.lab4_start.R;

/**
 * Aktywność dodająca nowy komentarz.
 *
 * @author Michał Ciołek
 */
public class AddCommentActivity extends AppCompatActivity {
    public static final String COMMENTS_FILE = "comments.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_comment);
    }

    public void addComment(View view) {
        EditText editText = findViewById(R.id.comment);

        File file = new File(getFilesDir(), COMMENTS_FILE);
        BufferedWriter bw = null;

        Log.d("ściezka pliku:", file.toString());
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(editText.getText().toString());
            bw.newLine();
            bw.close();
            Toast.makeText(this, "Komentarz dodany.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Nie udało się dodać: " + e.getCause(), Toast.LENGTH_SHORT).show();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
