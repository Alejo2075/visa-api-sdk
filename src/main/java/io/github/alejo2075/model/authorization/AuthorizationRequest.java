package io.github.alejo2075.model.authorization;

/**
 * Abstract base class for authorization requests.
 * Extend this class to include network-specific fields and validations.
 */
public abstract class AuthorizationRequest {

    protected String primaryAccountNumber;
    protected String cardHolderName;
    protected String expirationDate; // Format: MM/YY
    protected String cvv;
    protected double amount;
    protected String currencyCode;
    protected String merchantId;
    protected String referenceId;

    /**
     * Default constructor.
     */
    public AuthorizationRequest() {
    }

    /**
     * Constructs an AuthorizationRequest with specified details.
     *
     * @param primaryAccountNumber Cardholder's PAN
     * @param cardHolderName       Name on the card
     * @param expirationDate       Card's expiration date (MM/YY)
     * @param cvv                  Card Verification Value
     * @param amount               Transaction amount
     * @param currencyCode         Currency code (e.g., USD)
     * @param merchantId           Identifier for the merchant
     * @param referenceId          Unique reference for the transaction
     */
    public AuthorizationRequest(String primaryAccountNumber, String cardHolderName, String expirationDate,
                                String cvv, double amount, String currencyCode, String merchantId, String referenceId) {
        this.primaryAccountNumber = primaryAccountNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.merchantId = merchantId;
        this.referenceId = referenceId;
    }

    // Getters and Setters

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date.
     * Expected format: MM/YY
     *
     * @param expirationDate the expiration date to set
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the CVV code.
     *
     * @param cvv the CVV to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
