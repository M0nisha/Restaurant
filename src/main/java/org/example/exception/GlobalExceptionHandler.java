package org.example.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<APIResponse> handleException(Exception e){
        APIResponse apiResponse = new APIResponse();
        e.printStackTrace();
        apiResponse.setError("Oops..Something went wrong!");
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
    }
    @ExceptionHandler
    public ResponseEntity<APIResponse> handleException(MethodArgumentNotValidException e) {
        List<Error> errorMessages = e.getBindingResult().getFieldErrors().stream()
                .map(err -> new Error(err.getField(), err.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiResponse.setError(errorMessages);
        apiResponse.setMessage("failed");
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
    @ExceptionHandler
    public ResponseEntity<APIResponse> handleAccessDeniedException(AccessDeniedException e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setError("failed");
        apiResponse.setMessage("User login failed");
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
       return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
    @ExceptionHandler
    ResponseEntity<?> customException(CustomException e){
      APIResponse response = new APIResponse();
      response.setError(e.getError().name());
      response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
      response.setMessage("Simple Exception");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler
    String emailValException(ConstraintViolationException e, Model model) {
        model.addAttribute("error", "INVALID_EMAIL");
        return "signup";
    }

}






