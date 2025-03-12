package learn.graphql.Learn.GraphQl.resolver;

import learn.graphql.Learn.GraphQl.dto.BookRequest;
import learn.graphql.Learn.GraphQl.entity.Book;

import learn.graphql.Learn.GraphQl.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class BookResolver {

    @Autowired
    BookServiceImpl bookService;

    @QueryMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book bookBySlug(@Argument("slug") String slug) {
        return bookService.getBookSlug(slug);
    }

    @MutationMapping
    public Book createBook(@Argument("author_slug") String author_slug, @Argument("request") BookRequest bookRequest) {
        return bookService.addBook(author_slug, bookRequest);
    }

    @MutationMapping
    public Book updateBook(@Argument("author_slug") String author_slug, @Argument("book_slug") String book_slug, @Argument("request") BookRequest bookRequest) {
        return bookService.updateBook(author_slug, book_slug, bookRequest);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument("slug") String slug) {
        return bookService.deleteBook(slug);
    }
}
