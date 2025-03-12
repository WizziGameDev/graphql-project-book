package learn.graphql.Learn.GraphQl.error;

public class AuthorExceptionHandler extends RuntimeException {
    public AuthorExceptionHandler(String message) {
        super(message);
    }
}
