package io.github.alejo2075.core;


import io.github.alejo2075.exception.CardNetworkException;
import io.github.alejo2075.model.authorization.AuthorizationRequest;
import io.github.alejo2075.model.authorization.AuthorizationResponse;
import io.github.alejo2075.model.capture.CaptureBatchRequest;
import io.github.alejo2075.model.capture.CaptureBatchResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the CardNetworkClient interface.
 * Uses a mock implementation for testing purposes.
 */
public class CardNetworkClientTest {

    /**
     * Mock implementation of CardNetworkClient for testing.
     */
    private static class MockCardNetworkClient implements CardNetworkClient {

        @Override
        public AuthorizationResponse authorize(AuthorizationRequest request) throws CardNetworkException {
            // Mock behavior: return a successful authorization response
            return new AuthorizationResponse() {
                {
                    setAuthorizationCode("AUTH123456");
                    setTransactionId("TXN789012");
                    setStatus("APPROVED");
                    setMessage("Authorization successful");
                }
            };
        }

        @Override
        public CaptureBatchResponse capture(CaptureBatchRequest request) throws CardNetworkException {
            // Mock behavior: return a successful capture response
            return new CaptureBatchResponse() {
                {
                    setBatchId("BATCH123456");
                    setStatus("SUCCESS");
                    setMessage("Capture successful");
                    setTransactionResponses(java.util.Arrays.asList(
                            new CaptureTransactionResponse() {
                                {
                                    setTransactionId("TXN789012");
                                    setStatus("SUCCESS");
                                    setMessage("Capture completed");
                                }
                            }
                    ));
                }
            };
        }
    }

    /**
     * Tests the authorize method of CardNetworkClient.
     *
     * @throws CardNetworkException if an error occurs during authorization
     */
    @Test
    void testAuthorize() throws CardNetworkException {
        CardNetworkClient client = new MockCardNetworkClient();

        AuthorizationRequest request = new AuthorizationRequest() {
            {
                setPrimaryAccountNumber("4111111111111111");
                setCardHolderName("John Doe");
                setExpirationDate("12/25");
                setCvv("123");
                setAmount(100.00);
                setCurrencyCode("USD");
                setMerchantId("MERCHANT001");
                setReferenceId("REF001");
            }
        };

        AuthorizationResponse response = client.authorize(request);

        assertNotNull(response, "AuthorizationResponse should not be null");
        assertEquals("AUTH123456", response.getAuthorizationCode(), "Authorization code should match");
        assertEquals("TXN789012", response.getTransactionId(), "Transaction ID should match");
        assertEquals("APPROVED", response.getStatus(), "Status should be APPROVED");
        assertEquals("Authorization successful", response.getMessage(), "Message should indicate success");
    }

    /**
     * Tests the capture method of CardNetworkClient.
     *
     * @throws CardNetworkException if an error occurs during capture
     */
    @Test
    void testCapture() throws CardNetworkException {
        CardNetworkClient client = new MockCardNetworkClient();

        CaptureBatchRequest request = new CaptureBatchRequest() {
            {
                setBatchId("BATCH123456");
                setMerchantId("MERCHANT001");
                setTransactions(java.util.Arrays.asList(
                        new CaptureBatchRequest.CaptureTransaction() {
                            {
                                setTransactionId("TXN789012");
                                setAmount(100.00);
                            }
                        }
                ));
            }
        };

        CaptureBatchResponse response = client.capture(request);

        assertNotNull(response, "CaptureBatchResponse should not be null");
        assertEquals("BATCH123456", response.getBatchId(), "Batch ID should match");
        assertEquals("SUCCESS", response.getStatus(), "Status should be SUCCESS");
        assertEquals("Capture successful", response.getMessage(), "Message should indicate success");
        assertNotNull(response.getTransactionResponses(), "Transaction responses should not be null");
        assertEquals(1, response.getTransactionResponses().size(), "There should be one transaction response");
        CaptureBatchResponse.CaptureTransactionResponse txnResp = response.getTransactionResponses().get(0);
        assertEquals("TXN789012", txnResp.getTransactionId(), "Transaction ID should match");
        assertEquals("SUCCESS", txnResp.getStatus(), "Transaction status should be SUCCESS");
        assertEquals("Capture completed", txnResp.getMessage(), "Transaction message should indicate completion");
    }

    /**
     * Tests that authorize method throws CardNetworkException when an error occurs.
     */
    @Test
    void testAuthorizeThrowsException() {
        CardNetworkClient client = new CardNetworkClient() {
            @Override
            public AuthorizationResponse authorize(AuthorizationRequest request) throws CardNetworkException {
                throw new CardNetworkException("Authorization service unavailable");
            }

            @Override
            public CaptureBatchResponse capture(CaptureBatchRequest request) throws CardNetworkException {
                return null;
            }
        };

        AuthorizationRequest request = new AuthorizationRequest() {
            {
                setPrimaryAccountNumber("4111111111111111");
                setCardHolderName("John Doe");
                setExpirationDate("12/25");
                setCvv("123");
                setAmount(100.00);
                setCurrencyCode("USD");
                setMerchantId("MERCHANT001");
                setReferenceId("REF001");
            }
        };

        CardNetworkException exception = assertThrows(CardNetworkException.class, () -> {
            client.authorize(request);
        }, "Expected authorize to throw CardNetworkException");

        assertEquals("Authorization service unavailable", exception.getMessage(), "Exception message should match");
    }

    /**
     * Tests that capture method throws CardNetworkException when an error occurs.
     */
    @Test
    void testCaptureThrowsException() {
        CardNetworkClient client = new CardNetworkClient() {
            @Override
            public AuthorizationResponse authorize(AuthorizationRequest request) throws CardNetworkException {
                return null;
            }

            @Override
            public CaptureBatchResponse capture(CaptureBatchRequest request) throws CardNetworkException {
                throw new CardNetworkException("Capture service unavailable");
            }
        };

        CaptureBatchRequest request = new CaptureBatchRequest() {
            {
                setBatchId("BATCH123456");
                setMerchantId("MERCHANT001");
                setTransactions(java.util.Arrays.asList(
                        new CaptureBatchRequest.CaptureTransaction() {
                            {
                                setTransactionId("TXN789012");
                                setAmount(100.00);
                            }
                        }
                ));
            }
        };

        CardNetworkException exception = assertThrows(CardNetworkException.class, () -> {
            client.capture(request);
        }, "Expected capture to throw CardNetworkException");

        assertEquals("Capture service unavailable", exception.getMessage(), "Exception message should match");
    }
}
