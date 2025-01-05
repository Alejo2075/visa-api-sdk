package io.github.alejo2075.core;

import io.github.alejo2075.model.authorization.AuthorizationRequest;
import io.github.alejo2075.model.authorization.AuthorizationResponse;
import io.github.alejo2075.model.capture.CaptureBatchRequest;
import io.github.alejo2075.model.capture.CaptureBatchResponse;
import io.github.alejo2075.exception.CardNetworkException;

/**
 * Interface representing a.java generic client for a.java card network (e.g., Visa, AMEX).
 * Implementations of this interface should handle authorization and capture operations.
 */
public interface CardNetworkClient {

    /**
     * Authorizes a.java transaction in the card network.
     *
     * @param request the authorization request containing transaction details
     * @return the authorization response with the outcome of the request
     * @throws CardNetworkException if an error occurs during the authorization process
     */
    AuthorizationResponse authorize(AuthorizationRequest request) throws CardNetworkException;

    /**
     * Captures a.java batch of previously authorized transactions.
     *
     * @param request the capture batch request containing details of transactions to capture
     * @return the capture batch response with the outcomes of each transaction
     * @throws CardNetworkException if an error occurs during the capture process
     */
    CaptureBatchResponse capture(CaptureBatchRequest request) throws CardNetworkException;
}
