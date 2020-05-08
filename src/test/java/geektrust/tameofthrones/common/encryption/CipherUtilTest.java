package geektrust.tameofthrones.common.encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CipherUtilTest {

    @Test
    void testEncrypt_validInputValue_shouldReturnAValidEncryptedText() {
        // Setup
        final String value1 = "GORILLA";
        final String expectedResult1 = "NVYPSSH";

        final String value2 = "OCTOPUS";
        final String expectedResult2 = "VJAVWBZ";

        final String value3 = "OWL";
        final String expectedResult3 = "RZO";

        // Run the test
        final String result1 = CipherUtil.encrypt(value1);
        final String result2 = CipherUtil.encrypt(value2);
        final String result3 = CipherUtil.encrypt(value3);

        // Verify the results
        assertEquals(expectedResult1, result1);
        assertEquals(expectedResult2, result2);
        assertEquals(expectedResult3, result3);
    }
}
