package geektrust.tameofthrones.validation.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static geektrust.tameofthrones.constants.TameOfThronesConstantsTest.File.VALID_PATH_ONE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RequestValidationImplTest {

    private RequestValidationImpl requestValidationImplUnderTest;

    @BeforeEach
    void setUp() {
        requestValidationImplUnderTest = new RequestValidationImpl();
    }

    @Test
    void testIsFilePathPresent_filePathIsPresent_shouldReturnTrue() {
        // Setup
        final String[] arguments = new String[]{VALID_PATH_ONE};

        // Run the test
        final boolean result = requestValidationImplUnderTest.isFilePathPresent(arguments);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testIsFilePathPresent_filePathNotPresent_shouldReturnFalse() {
        // Setup
        final String[] arguments = new String[]{};

        // Run the test
        final boolean result = requestValidationImplUnderTest.isFilePathPresent(arguments);

        // Verify the results
        assertFalse(result);
    }
}
