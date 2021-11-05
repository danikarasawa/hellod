package daniela.dev.hellod.config.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ControllerExceptionHandler {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ApiError> handleValidationException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors().stream().map(f -> ApiError
                                                    .builder()
                                                    .field(f.getField())
                                                    .message(f.getDefaultMessage())
                                                    .build())
                                                    .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handleError(Exception e) {
        return ApiError.builder()
                       .message("Ocorreu um erro inesperado. Volte mais tarde").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiError handleError(NotFoundException e) {
        return ApiError.builder()
                       .message("Ocorreu um erro inesperado. Volte mais tarde").build();
    }
}
