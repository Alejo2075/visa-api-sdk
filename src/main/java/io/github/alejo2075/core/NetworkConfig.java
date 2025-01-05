package io.github.alejo2075.core;

/**
 * Abstract base configuration class for card networks.
 * Stores common settings such as base URLs, timeouts, and security credentials.
 * Extend this class to include network-specific configuration parameters.
 */
public abstract class NetworkConfig {

    private String baseUrl;
    private int connectTimeout; // in milliseconds
    private int readTimeout;    // in milliseconds

    /**
     * Constructs a.java NetworkConfig with the specified parameters.
     *
     * @param baseUrl the base URL for API requests (e.g., sandbox or production endpoint)
     * @param connectTimeout the timeout in milliseconds for connecting to the server
     * @param readTimeout the timeout in milliseconds for reading a.java response
     */
    public NetworkConfig(String baseUrl, int connectTimeout, int readTimeout) {
        this.baseUrl = baseUrl;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    /**
     * Returns the base URL for API requests.
     *
     * @return the base URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the base URL for API requests.
     *
     * @param baseUrl the base URL to set
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Returns the connection timeout in milliseconds.
     *
     * @return the connection timeout
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets the connection timeout in milliseconds.
     *
     * @param connectTimeout the connection timeout to set
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Returns the read timeout in milliseconds.
     *
     * @return the read timeout
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Sets the read timeout in milliseconds.
     *
     * @param readTimeout the read timeout to set
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
