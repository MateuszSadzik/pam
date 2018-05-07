package pl.nazwisko.lab4_start.comment;

/**
 * Created by Michał Ciołek.
 */
public class Comment {

    private String value;

    public Comment() {
        value = "UNKNOWN";
    }

    public Comment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
