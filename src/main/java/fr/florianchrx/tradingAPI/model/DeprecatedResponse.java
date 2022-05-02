package fr.florianchrx.tradingAPI.model;

public class DeprecatedResponse<T> extends Response<T> {
    public DeprecatedResponse(T data, boolean success, String message) {
        super(data, success, message);
        this.setMessage("Deprecation alert : this API call is actually deprecated. Please check documentation to use the alternative.\n\n" + this.getMessage());
    }

    public DeprecatedResponse(T data, boolean success) {
        this(data, success, null);
    }

    public DeprecatedResponse(T data) {
        this(data, true);
    }
}
