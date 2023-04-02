package demo.restfulWebService.exception;

import demo.restfulWebService.service.ExceptionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.springframework.expression.spel.SpelEvaluationException;


@ControllerAdvice
@AllArgsConstructor
@Log4j2
public class WholeAppExceptionHandler {

    record ApiErrorDetails(int code, String cause){}

    private final ExceptionService exceptionService;

    @ExceptionHandler({ApiError.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiErrorDetails handleExceptionSimple(ApiError ex) {
        return new ApiErrorDetails(
                555,
                ex.getClass().getSimpleName()
        );
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ModelAndView entityNotFoundException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

    @ExceptionHandler({NullPointerException.class})
    public ModelAndView nullPointerException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

    @ExceptionHandler({TemplateProcessingException.class})
    public ModelAndView templateProcessingException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

    @ExceptionHandler({SpelEvaluationException.class})
    public ModelAndView spelEvaluationException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView httpRequestMethodNotSupportedException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView runtimeException(RuntimeException ex) {
        return exceptionService.getException(ex);
    }

}
