package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.exceptionhandler.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    @ExceptionHandler(value = {UserNotFoundException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleBusinessException(Exception ex, HttpServletRequest request) {
        LOGGER.debug("======Inside handleBusinessException() ======================");
        LOGGER.info("=========request URI: " + request.getRequestURI());

        LOGGER.error("Exception Error = " + ex);

        ModelAndView mv = new ModelAndView("management/600");
        mv.addObject("errorMsg", ex.getMessage());
        mv.addObject("errorStack", ex.getCause());

        LOGGER.warn("==============Be careful::::::::::::::::::;");

        return mv;
    }
}
