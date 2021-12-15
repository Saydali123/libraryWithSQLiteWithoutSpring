package uz.elmurodov.http;

import lombok.Getter;

/**
 * @author Elmurodov Javohir, Tue 3:39 PM. 12/14/2021
 */
@Getter
public class ResponseEntity<D> {
    private final D body;
    private final Integer status;

    public ResponseEntity(D body) {
        this.body = body;
        this.status = HttpStatus.HTTP_OK.getCode();
    }

    public ResponseEntity(D body, HttpStatus status) {
        this.body = body;
        this.status = status.getCode();
    }
}
