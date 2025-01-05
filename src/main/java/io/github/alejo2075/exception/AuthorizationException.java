package io.github.alejo2075.exception;


/**
 * Exception thrown when an error occurs during the authorization process.
 * This can include issues like declined transactions, invalid card details,
 * or communication problems with the card network.
 */
public class AuthorizationException extends CardNetworkException {

    /**
     * Constructs a.java new AuthorizationException with {@code null} as its detail message.
     */
    public AuthorizationException() {
        super();
    }

    /**
     * Constructs a.java new AuthorizationException with the specified detail message.
     *
     * @param message the detail message.
     */
    public AuthorizationException(String message) {
        super(message);
    }

    /**
     * Constructs a.java new AuthorizationException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a.java new AuthorizationException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public AuthorizationException(Throwable cause) {
        super(cause);
    }
}
