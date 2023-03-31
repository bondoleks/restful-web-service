package demo.restfulWebService.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleEntityNotFoundException(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleNullPointerException(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }
    @ExceptionHandler(TemplateProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo templateProcessingException(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }

    @ExceptionHandler(SpelEvaluationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo spelEvaluationException(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorInfo handleMethodNotSupported(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorInfo handleIOException(HttpServletRequest request, Exception ex) {
        return new ErrorInfo(request.getRequestURL().toString(), ex);
    }
}
