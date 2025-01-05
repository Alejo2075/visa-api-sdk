package io.github.alejo2075.exception;

/**
 * Exception thrown when an error occurs during the capture process.
 * This can include issues like failed batch captures, invalid transaction IDs,
 * or communication problems with the card network.
 */
public class CaptureException extends CardNetworkException {

    /**
     * Constructs a.java new CaptureException with {@code null} as its detail message.
     */
    public CaptureException() {
        super();
    }

    /**
     * Constructs a.java new CaptureException with the specified detail message.
     *
     * @param message the detail message.
     */
    public CaptureException(String message) {
        super(message);
    }

    /**
     * Constructs a.java new CaptureException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public CaptureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a.java new CaptureException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public CaptureException(Throwable cause) {
        super(cause);
    }
}
