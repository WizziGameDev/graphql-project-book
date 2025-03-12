package learn.graphql.Learn.GraphQl.repository;

import learn.graphql.Learn.GraphQl.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByIsDeleted(Boolean isDeleted);

    Optional<Author> findFirstBySlugAndIsDeleted(String slug, Boolean isDeleted);
}
