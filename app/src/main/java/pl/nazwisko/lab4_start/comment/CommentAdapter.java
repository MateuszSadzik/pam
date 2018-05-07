package pl.nazwisko.lab4_start.comment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.nazwisko.lab4_start.R;

/**
 * Created by Michał Ciołek.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> comments;

    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.comment_list_element, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. tytułu)
        ViewHolder viewHolder = new ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        holder.comment.setText(comments.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //widgety z comment_list_element.xml
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            //wyszukanie widgetów
            comment = (TextView) itemView.findViewById(R.id.comment);
        }
    }
}
