package io.github.alejo2075.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the NetworkConfig abstract class.
 * Uses a concrete subclass for testing purposes.
 */
public class NetworkConfigTest {

    /**
     * Concrete subclass of NetworkConfig for testing.
     */
    private static class MockNetworkConfig extends NetworkConfig {
        public MockNetworkConfig(String baseUrl, int connectTimeout, int readTimeout) {
            super(baseUrl, connectTimeout, readTimeout);
        }
    }

    /**
     * Tests the getters and setters of NetworkConfig.
     */
    @Test
    void testGettersAndSetters() {
        String baseUrl = "https://api.testnetwork.com";
        int connectTimeout = 3000;
        int readTimeout = 5000;

        MockNetworkConfig config = new MockNetworkConfig(baseUrl, connectTimeout, readTimeout);

        // Verify initial values
        assertEquals(baseUrl, config.getBaseUrl(), "Base URL should match the initial value");
        assertEquals(connectTimeout, config.getConnectTimeout(), "Connect timeout should match the initial value");
        assertEquals(readTimeout, config.getReadTimeout(), "Read timeout should match the initial value");

        // Update values
        String newBaseUrl = "https://api.newnetwork.com";
        int newConnectTimeout = 4000;
        int newReadTimeout = 6000;

        config.setBaseUrl(newBaseUrl);
        config.setConnectTimeout(newConnectTimeout);
        config.setReadTimeout(newReadTimeout);

        // Verify updated values
        assertEquals(newBaseUrl, config.getBaseUrl(), "Base URL should match the updated value");
        assertEquals(newConnectTimeout, config.getConnectTimeout(), "Connect timeout should match the updated value");
        assertEquals(newReadTimeout, config.getReadTimeout(), "Read timeout should match the updated value");
    }
}
