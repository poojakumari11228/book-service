package books.service;

import books.domain.Book;
import books.dto.Books;

public interface BookService {

    void addBook(Book book);

    Book getBook(String isbn);

    void deleteBook(String isbn);

    void updateBook(Book book);

    Books getAllBooks();
}
