package learn.graphql.Learn.GraphQl.service;

import learn.graphql.Learn.GraphQl.dto.BookRequest;
import learn.graphql.Learn.GraphQl.entity.Book;

import java.util.List;

public interface BookService {

    // get all
    List<Book> getAllBooks();

    // get by slug
    Book getBookSlug(String slug);

    // post book
    Book addBook(String author_slug, BookRequest request);

    // update book
    Book updateBook(String author_slug, String book_slug, BookRequest request);

    // delete book
    Boolean deleteBook(String slug);
}
