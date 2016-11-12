package ironyard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Created by favianalopez on 11/8/16.
 */

/**
 * Example taken from: https://github.com/jskipgit/example-upload/blob/master/src/main/java/com/ironyard/movies/controler/GlobalExceptionHandler.java
 */
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Throwable.class)
    public String handleBaseException(Throwable e){
        return e.getMessage();
    }

    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException(Exception e){return e.getMessage();}

}
