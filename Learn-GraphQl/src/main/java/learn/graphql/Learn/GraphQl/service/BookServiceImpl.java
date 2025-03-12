package learn.graphql.Learn.GraphQl.service;

import jakarta.transaction.Transactional;
import learn.graphql.Learn.GraphQl.dto.BookRequest;
import learn.graphql.Learn.GraphQl.entity.Author;
import learn.graphql.Learn.GraphQl.entity.Book;
import learn.graphql.Learn.GraphQl.error.BookExceptionHandler;
import learn.graphql.Learn.GraphQl.repository.AuthorRepository;
import learn.graphql.Learn.GraphQl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllByDeleted(false);
    }

    @Override
    public Book getBookSlug(String slug) {
        return bookRepository.findFirstBySlugAndDeleted(slug, false)
                .orElseThrow(() -> new BookExceptionHandler("Book not found"));
    }

    @Override
    @Transactional
    public Book addBook(String author_slug, BookRequest request) {
        Boolean findBook = bookRepository.findFirstBySlugAndDeleted(request.getSlug(), false).isPresent();

        Author author = authorRepository.findFirstBySlugAndIsDeleted(author_slug, false).orElseThrow(() -> new BookExceptionHandler("Author not found"));

        if (findBook) {
            throw new BookExceptionHandler("Book already exists");
        }

        Book buildBook = new Book().builder()
                .slug(request.getSlug())
                .name(request.getName())
                .page(request.getPage())
                .createdAt(Instant.now().getEpochSecond())
                .deleted(false)
                .author(author)
                .build();

        return bookRepository.save(buildBook);
    }

    @Override
    @Transactional
    public Book updateBook(String author_slug, String book_slug, BookRequest request) {

        Book book = bookRepository.findFirstBySlugAndDeleted(book_slug, false).orElseThrow(() -> new BookExceptionHandler("Book not found"));

        Author author = authorRepository.findFirstBySlugAndIsDeleted(author_slug, false).orElseThrow(() -> new BookExceptionHandler("Author not found"));

        book.setName(request.getName());
        book.setPage(request.getPage());
        book.setSlug(request.getSlug());
        book.setAuthor(author);
        book.setDeleted(false);

        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Boolean deleteBook(String slug) {
        Book book = bookRepository.findFirstBySlugAndDeleted(slug, false).orElseThrow(() -> new BookExceptionHandler("Book not found"));

        bookRepository.delete(book);

        return true;
    }
}
