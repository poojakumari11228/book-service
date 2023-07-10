package books.repository.impl;

import books.domain.Book;
import books.repository.BookRepo;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepoImpl implements BookRepo {

    private Map<String, Book> books = new HashMap<>();

    BookRepoImpl(){
        books.put("123", new Book("123", "Pooja Kumari", "Software Architecture", 1000.0));
    }

    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void update(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book delete(String isbn) {
        Book deleteBook = books.get(isbn);
        books.remove(isbn);
        return deleteBook;
    }

    public Book get(String isbn) {
        return books.get(isbn);
    }

    public Map<String, Book> findAll() {
        return books;
    }
}
