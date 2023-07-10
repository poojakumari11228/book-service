package books.dto;

import books.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Books {

 private Map<String, Book> books;
}
