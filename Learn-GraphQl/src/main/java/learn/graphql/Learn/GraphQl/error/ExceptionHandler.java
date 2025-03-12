package learn.graphql.Learn.GraphQl.error;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleBookError(BookExceptionHandler exceptionHandler) {
        return GraphQLError.newError()
                .message(exceptionHandler.getMessage())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleAuthorError(AuthorExceptionHandler exceptionHandler) {
        return GraphQLError.newError()
                .message(exceptionHandler.getMessage())
                .build();
    }
}