package io.github.alejo2075.model.authorization;

/**
 * Abstract base class for authorization responses.
 * Extend this class to include network-specific response details.
 */
public abstract class AuthorizationResponse {

    protected String authorizationCode;
    protected String transactionId;
    protected String status;
    protected String message;

    /**
     * Default constructor.
     */
    public AuthorizationResponse() {
    }

    /**
     * Constructs an AuthorizationResponse with specified details.
     *
     * @param authorizationCode Authorization code
     * @param transactionId     Transaction ID
     * @param status            Authorization status
     * @param message           Additional message
     */
    public AuthorizationResponse(String authorizationCode, String transactionId, String status, String message) {
        this.authorizationCode = authorizationCode;
        this.transactionId = transactionId;
        this.status = status;
        this.message = message;
    }

    // Getters and Setters

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
