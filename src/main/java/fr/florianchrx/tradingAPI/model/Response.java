package fr.florianchrx.tradingAPI.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * It's the response type of the API. It permits to send a flag of success and
 * a message in add to the data
 *
 * @param <T> The data type
 */
@Getter
@Setter
@EqualsAndHashCode
public class Response<T> {
    private T data;
    private boolean success;
    private String message;

    public Response(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
        if (data == null) this.success = false;
        if (!success && message == null) this.message = "An error has occurred";
        if (success && message == null) this.message = "Operation has success";
    }

    public Response(T data, boolean success) {
        this(data, success, null);
    }

    public Response(T data) {
        this(data, true);
    }
}
