package learn.graphql.Learn.GraphQl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String slug;

    private String name;

    private Integer page;
}
