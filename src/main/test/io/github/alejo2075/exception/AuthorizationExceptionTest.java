package io.github.alejo2075.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the AuthorizationException class.
 * Ensures that all constructors behave as expected.
 */
public class AuthorizationExceptionTest {

    /**
     * Tests the default constructor of AuthorizationException.
     * Verifies that the exception message is null.
     */
    @Test
    void testDefaultConstructor() {
        AuthorizationException exception = new AuthorizationException();
        assertNull(exception.getMessage(), "Exception message should be null");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of AuthorizationException with a message.
     * Verifies that the message is correctly set.
     */
    @Test
    void testConstructorWithMessage() {
        String message = "Authorization failed";
        AuthorizationException exception = new AuthorizationException(message);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of AuthorizationException with a message and cause.
     * Verifies that both the message and cause are correctly set.
     */
    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Authorization failed due to network issue";
        Throwable cause = new RuntimeException("Network timeout");
        AuthorizationException exception = new AuthorizationException(message, cause);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }

    /**
     * Tests the constructor of AuthorizationException with a cause.
     * Verifies that the cause is correctly set and the message matches the cause's message.
     */
    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Underlying cause only");
        AuthorizationException exception = new AuthorizationException(cause);
        assertEquals(cause.toString(), exception.getMessage(), "Exception message should match the cause's toString()");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }
}
