package learn.graphql.Learn.GraphQl.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    private String name;

    private String slug;

    private String email;

    private String gender;
}
