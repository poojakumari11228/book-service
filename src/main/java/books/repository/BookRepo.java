package books.repository;

import books.domain.Book;
import java.util.Map;

public interface BookRepo {
    Map<String, Book> findAll();
    Book get(String isbn);
    void save(Book book);
    Book delete(String isbn);
    void update(Book book);
}
