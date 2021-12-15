package uz.elmurodov.http;

import lombok.Getter;

/**
 * @author Elmurodov Javohir, Tue 3:43 PM. 12/14/2021
 */
@Getter
public class Data<T> {
    private T data;
    private Integer total;

    public Data(T data) {
        this.data = data;
    }

    public Data(T data, Integer total) {
        this.data = data;
        this.total = total;
    }
}
