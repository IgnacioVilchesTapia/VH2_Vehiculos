package cl.duoc.HuechurabaBMW.except;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> manejarError(RuntimeException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("mensaje", ex.getMessage());

        return error;
    }
}