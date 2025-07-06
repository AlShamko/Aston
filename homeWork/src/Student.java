import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Student {
    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return name + books;
    }
};

