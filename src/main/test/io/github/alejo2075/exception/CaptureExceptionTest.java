package io.github.alejo2075.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the CaptureException class.
 * Ensures that all constructors behave as expected.
 */
public class CaptureExceptionTest {

    /**
     * Tests the default constructor of CaptureException.
     * Verifies that the exception message is null.
     */
    @Test
    void testDefaultConstructor() {
        CaptureException exception = new CaptureException();
        assertNull(exception.getMessage(), "Exception message should be null");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of CaptureException with a message.
     * Verifies that the message is correctly set.
     */
    @Test
    void testConstructorWithMessage() {
        String message = "Capture process failed";
        CaptureException exception = new CaptureException(message);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertNull(exception.getCause(), "Exception cause should be null");
    }

    /**
     * Tests the constructor of CaptureException with a message and cause.
     * Verifies that both the message and cause are correctly set.
     */
    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Capture failed due to invalid transaction ID";
        Throwable cause = new RuntimeException("Invalid ID format");
        CaptureException exception = new CaptureException(message, cause);
        assertEquals(message, exception.getMessage(), "Exception message should match the provided message");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }

    /**
     * Tests the constructor of CaptureException with a cause.
     * Verifies that the cause is correctly set and the message matches the cause's message.
     */
    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Underlying cause only");
        CaptureException exception = new CaptureException(cause);
        assertEquals(cause.toString(), exception.getMessage(), "Exception message should match the cause's toString()");
        assertEquals(cause, exception.getCause(), "Exception cause should match the provided cause");
    }
}
