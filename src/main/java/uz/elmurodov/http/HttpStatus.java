package uz.elmurodov.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Elmurodov Javohir, Tue 3:41 PM. 12/14/2021
 */

@Getter
@AllArgsConstructor
public enum HttpStatus {
    HTTP_OK(200),
    HTTP_NOT_FOUND(404),
    HTTP_BAD_REQUEST(405),
    HTTP_FORBIDDEN(403),
    UNDEFINED(-1);
    private final Integer code;
}
