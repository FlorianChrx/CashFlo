package fr.florianchrx.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Response <T> {
    private T data;
    private boolean success;
    private String message;
}
