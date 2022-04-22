package fr.florianchrx.tradingAPI.model;

import lombok.*;

/**
 * It's the response type of the API. It permits to send a flag of success and
 * a message in add to the data
 *
 * @param <T> The data type
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Response<T> {
    private T data;
    private boolean success;
    private String message;
}
