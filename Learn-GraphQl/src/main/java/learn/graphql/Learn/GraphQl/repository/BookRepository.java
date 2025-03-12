package learn.graphql.Learn.GraphQl.repository;

import learn.graphql.Learn.GraphQl.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.deleted = :delete")
    List<Book> findAllByDeleted(Boolean delete);

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.slug = :slug AND b.deleted = :delete")
    Optional<Book> findFirstBySlugAndDeleted(String slug, Boolean delete);
}