package books.service.impl;

import books.Integration.JmsSender;
import books.domain.Book;
import books.dto.Books;
import books.repository.BookRepo;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    private JmsSender jmsSender;
    @Autowired
    BookServiceImpl(BookRepo bookRepo, JmsSender jmsSender){
        this.bookRepo = bookRepo;
        this.jmsSender = jmsSender;
    }

    public void addBook(Book book){
        bookRepo.save(book);
        jmsSender.sendMessage(book);
    }

    public void updateBook(Book book){
        bookRepo.update(book);
        jmsSender.sendMessage(book);
    }

    public void deleteBook(String isbn){
        Book deletedBook = bookRepo.delete(isbn);
        jmsSender.sendMessage(deletedBook);
    }

    public Book getBook(String isbn){
        return bookRepo.get(isbn);
    }

    public Books getAllBooks(){
        return new Books(bookRepo.findAll());
    }


}
