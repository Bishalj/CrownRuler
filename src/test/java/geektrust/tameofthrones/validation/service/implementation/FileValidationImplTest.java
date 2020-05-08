package geektrust.tameofthrones.validation.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static geektrust.tameofthrones.constants.TameOfThronesConstantsTest.File.INVALID_PATH;
import static geektrust.tameofthrones.constants.TameOfThronesConstantsTest.File.VALID_PATH_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileValidationImplTest {

    private FileValidationImpl fileValidationImplUnderTest;

    @BeforeEach
    void setUp() {
        fileValidationImplUnderTest = new FileValidationImpl();
    }

    @Test
    void testGetValidFile_validFilePath_shouldReturnTheFile() {
        // Setup
        final String filePath = VALID_PATH_ONE;
        final File expectedResult = new File(filePath);

        // Run the test
        final File result = fileValidationImplUnderTest.getValidFile(filePath);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetValidFile_filePathDoesNotExists_throwsIllegalArgumentException() {
        // Setup
        final String filePath = INVALID_PATH;

        // Run the test
        assertThrows(IllegalArgumentException.class, () -> {
            fileValidationImplUnderTest.getValidFile(filePath);
        });
    }
}
