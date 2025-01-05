package io.github.alejo2075.model.capture;

import java.util.List;

/**
 * Abstract base class for batch capture requests.
 * Extend this class to include network-specific fields and validations.
 */
public abstract class CaptureBatchRequest {

    protected String batchId;
    protected String merchantId;
    protected List<CaptureTransaction> transactions;

    /**
     * Default constructor.
     */
    public CaptureBatchRequest() {
    }

    /**
     * Constructs a.java CaptureBatchRequest with specified details.
     *
     * @param batchId     Batch identifier for the capture operation
     * @param merchantId  Identifier for the merchant
     * @param transactions List of transactions to capture
     */
    public CaptureBatchRequest(String batchId, String merchantId, List<CaptureTransaction> transactions) {
        this.batchId = batchId;
        this.merchantId = merchantId;
        this.transactions = transactions;
    }

    // Getters and Setters

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public List<CaptureTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<CaptureTransaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Abstract class representing an individual transaction within a.java capture batch.
     * Extend this class to include network-specific transaction details.
     */
    public static abstract class CaptureTransaction {

        protected String transactionId;
        protected double amount;

        /**
         * Default constructor.
         */
        public CaptureTransaction() {
        }

        /**
         * Constructs a.java CaptureTransaction with specified details.
         *
         * @param transactionId Transaction ID to capture
         * @param amount        Amount to capture
         */
        public CaptureTransaction(String transactionId, double amount) {
            this.transactionId = transactionId;
            this.amount = amount;
        }

        // Getters and Setters

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
