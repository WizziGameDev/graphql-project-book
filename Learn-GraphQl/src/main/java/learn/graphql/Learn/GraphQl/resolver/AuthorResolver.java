package learn.graphql.Learn.GraphQl.resolver;

import learn.graphql.Learn.GraphQl.dto.AuthorRequest;
import learn.graphql.Learn.GraphQl.entity.Author;
import learn.graphql.Learn.GraphQl.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorResolver {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public List<Author> authors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author authorBySlug(@Argument String slug) {
        return authorService.getAuthorSlug(slug);
    }

    @MutationMapping
    public Author createAuthor(@Argument("request") AuthorRequest authorRequest) {
        return authorService.addAuthor(authorRequest);
    }

    @MutationMapping
    public Author updateAuthor(@Argument("slug") String slug, @Argument("request") AuthorRequest authorRequest) {
        return authorService.updateAuthor(slug, authorRequest);
    }

    @MutationMapping
    public Boolean deleteAuthor(@Argument("slug")String slug) {
        return authorService.deleteAuthor(slug);
    }
}
