package io.github.alejo2075.exception;

/**
 * Base exception class for all card network-related errors.
 * This exception should be used to represent general issues encountered
 * while interacting with card networks such as Visa or AMEX.
 */
public class CardNetworkException extends Exception {

    /**
     * Constructs a.java new CardNetworkException with {@code null} as its detail message.
     */
    public CardNetworkException() {
        super();
    }

    /**
     * Constructs a.java new CardNetworkException with the specified detail message.
     *
     * @param message the detail message.
     */
    public CardNetworkException(String message) {
        super(message);
    }

    /**
     * Constructs a.java new CardNetworkException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public CardNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a.java new CardNetworkException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public CardNetworkException(Throwable cause) {
        super(cause);
    }
}
