package learn.graphql.Learn.GraphQl.service;

import jakarta.transaction.Transactional;
import learn.graphql.Learn.GraphQl.dto.AuthorRequest;
import learn.graphql.Learn.GraphQl.entity.Author;
import learn.graphql.Learn.GraphQl.error.AuthorExceptionHandler;
import learn.graphql.Learn.GraphQl.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAllByIsDeleted(false);
    }

    @Override
    public Author getAuthorSlug(String slug) {
        return authorRepository.findFirstBySlugAndIsDeleted(slug, false).orElseThrow(() -> new AuthorExceptionHandler("Author does not exist"));
    }

    @Override
    @Transactional
    public Author addAuthor(AuthorRequest request) {
        boolean exist = authorRepository.findFirstBySlugAndIsDeleted(request.getSlug(), false).isPresent();
        if (exist) {
            throw new AuthorExceptionHandler("Author already exists");
        }

        Author buildAuthor = Author.builder()
                .slug(request.getSlug())
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .createdAt(Instant.now().getEpochSecond())
                .updatedAt(null)
                .isDeleted(false)
                .build();

        return authorRepository.save(buildAuthor);
    }

    @Override
    @Transactional
    public Author updateAuthor(String slug, AuthorRequest request) {
        Author authorFound = authorRepository.findFirstBySlugAndIsDeleted(slug, false).orElseThrow(() -> new AuthorExceptionHandler("Author does not exist"));

        authorFound.setName(request.getName());
        authorFound.setEmail(request.getEmail());
        authorFound.setSlug(request.getSlug());
        authorFound.setUpdatedAt(Instant.now().getEpochSecond());
        return authorRepository.save(authorFound);
    }

    @Override
    @Transactional
    public Boolean deleteAuthor(String slug) {
        Author authorFound = authorRepository.findFirstBySlugAndIsDeleted(slug, false).orElseThrow(() -> new AuthorExceptionHandler("Author does not exist"));
        authorFound.setIsDeleted(true);

        authorRepository.save(authorFound);
        return true;
    }
}
