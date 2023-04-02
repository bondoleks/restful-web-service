package demo.restfulWebService.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
@AllArgsConstructor
@Log4j2
public class ExceptionService {

    public ModelAndView getException(RuntimeException ex) {
        log.error(String.format("Exception caught globally, class: %s", ex.getClass().getSimpleName()));
        log.error(String.format("Exception caught globally: %s", ex.getMessage()));

        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error_template");
        mav.setStatus(HttpStatus.NOT_IMPLEMENTED);
        mav.addObject("ex_name", ex.getClass().getSimpleName());
        mav.addObject("ex_stack", ex.getMessage());

        return mav;
    }
}
