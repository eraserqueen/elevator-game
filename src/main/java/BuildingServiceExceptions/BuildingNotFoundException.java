package BuildingServiceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No building found")  // 404
public class BuildingNotFoundException extends RuntimeException {

}
