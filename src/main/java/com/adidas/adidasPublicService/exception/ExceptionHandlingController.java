package com.adidas.adidasPublicService.exception;

import com.adidas.adidasPublicService.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Class for Exceptions control
 */
@ControllerAdvice
public class ExceptionHandlingController {

    final static Logger logger = Logger.getLogger(ExceptionHandlingController.class);

    /**
     * Control of unexpected Exception
     * @param ex
     * @return an ResponseEntity with a message for an unexpecte exception
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleError (Exception ex) {
        logger.error("Exception received ");
        logger.error("Exception cause "+ex.getCause());
        logger.error("Exception message "+ex.getMessage());
        return new ResponseEntity<>(Constants.Exceptions.EXCEPTION_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Control of unexpected Exception
     * @param ex
     * @return an ResponseEntity with a message for a request with wrong format
     */
    @ExceptionHandler(value=HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleError (HttpClientErrorException ex) {
        logger.error("Exception received ");
        logger.error("Exception cause "+ex.getCause());
        logger.error("Exception message "+ex.getMessage());
        return new ResponseEntity<>(Constants.Exceptions.EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST);
    }


}
