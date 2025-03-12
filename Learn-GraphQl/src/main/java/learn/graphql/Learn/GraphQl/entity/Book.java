package learn.graphql.Learn.GraphQl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String slug;

    private String name;

    private Integer page;

    @Column(name = "created_at")
    private Long createdAt;

    private Boolean deleted;

    @ManyToOne
    @JoinColumn(
            name = "author_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Author author;
}
