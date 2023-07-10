package books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Book {
    private String isbn;
    private String author;
    private String title;
    private double price;
}
