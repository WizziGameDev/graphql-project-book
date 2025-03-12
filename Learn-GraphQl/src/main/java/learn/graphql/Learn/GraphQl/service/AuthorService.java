package learn.graphql.Learn.GraphQl.service;

import learn.graphql.Learn.GraphQl.dto.AuthorRequest;
import learn.graphql.Learn.GraphQl.entity.Author;

import java.util.List;

public interface AuthorService {

    // get all
    List<Author> getAllAuthors();

    // get by slug
    Author getAuthorSlug(String slug);

    // post book
    Author addAuthor(AuthorRequest request);

    // update book
    Author updateAuthor(String slug, AuthorRequest request);

    // delete book
    Boolean deleteAuthor(String slug);
}
