package BuildingServiceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No building id provided")  // 400
public class BuildingServiceBadDataException extends RuntimeException {
    public BuildingServiceBadDataException(String message) {
        super(message);
    }
}
