package io.github.alejo2075.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the CardNetworkException class.
 * Ensures that all constructors behave as expected.
 */
public class CardNetworkExceptionTest {

    /**
     * Tests the default constructor of CardNetworkException.
     * Verifies that the exception message is null.
     */
    @Test
    void testDefaultConstructor() {
        CardNetworkException exception = new CardNetworkException();
        assertNull(exception.getMessage(), "Exception message should be null");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of CardNetworkException with a message.
     * Verifies that the message is correctly set.
     */
    @Test
    void testConstructorWithMessage() {
        String message = "Network error occurred";
        CardNetworkException exception = new CardNetworkException(message);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of CardNetworkException with a message and cause.
     * Verifies that both the message and cause are correctly set.
     */
    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Network error with cause";
        Throwable cause = new RuntimeException("Underlying cause");
        CardNetworkException exception = new CardNetworkException(message, cause);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }

    /**
     * Tests the constructor of CardNetworkException with a cause.
     * Verifies that the cause is correctly set and the message matches the cause's message.
     */
    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Underlying cause only");
        CardNetworkException exception = new CardNetworkException(cause);
        assertEquals(cause.toString(), exception.getMessage(), "Exception message should match the cause's toString()");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }
}
