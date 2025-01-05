package io.github.alejo2075.model.capture;

import java.util.List;

/**
 * Abstract base class for batch capture responses.
 * Extend this class to include network-specific response details.
 */
public abstract class CaptureBatchResponse {

    protected String batchId;
    protected List<CaptureTransactionResponse> transactionResponses;
    protected String status;
    protected String message;

    /**
     * Default constructor.
     */
    public CaptureBatchResponse() {
    }

    /**
     * Constructs a.java CaptureBatchResponse with specified details.
     *
     * @param batchId             Batch identifier corresponding to the capture request
     * @param transactionResponses List of responses for each captured transaction
     * @param status              Overall status of the batch capture operation
     * @param message             Additional message or details
     */
    public CaptureBatchResponse(String batchId, List<CaptureTransactionResponse> transactionResponses,
                                String status, String message) {
        this.batchId = batchId;
        this.transactionResponses = transactionResponses;
        this.status = status;
        this.message = message;
    }

    // Getters and Setters

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<CaptureTransactionResponse> getTransactionResponses() {
        return transactionResponses;
    }

    public void setTransactionResponses(List<CaptureTransactionResponse> transactionResponses) {
        this.transactionResponses = transactionResponses;
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

    /**
     * Abstract class representing the response for an individual transaction within a.java capture batch.
     * Extend this class to include network-specific response details.
     */
    public static abstract class CaptureTransactionResponse {

        protected String transactionId;
        protected String status;
        protected String message;

        /**
         * Default constructor.
         */
        public CaptureTransactionResponse() {
        }

        /**
         * Constructs a.java CaptureTransactionResponse with specified details.
         *
         * @param transactionId Transaction ID corresponding to the capture request
         * @param status        Status of the capture for this transaction
         * @param message       Additional message or details
         */
        public CaptureTransactionResponse(String transactionId, String status, String message) {
            this.transactionId = transactionId;
            this.status = status;
            this.message = message;
        }

        // Getters and Setters

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
}
