package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests;
import geektrust.tameofthrones.kingdom.models.Kingdom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.FIRE;
import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.SPACE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingdomServiceImplTest {

    private KingdomServiceImpl kingdomServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        kingdomServiceImplUnderTest = new KingdomServiceImpl();
    }

    @Test
    void testGetKingdomDetailsByName_inputValidKingdomName_shouldReturnKingdomDetails() {
        // Setup

        final String kingdomName = SPACE;
        final String excludeFields= null;
        final Kingdom expectedResult = KingdomDetailsConstantTests.getKingdomDetailsByName(kingdomName);

        // Run the test
        final Kingdom result = kingdomServiceImplUnderTest.getKingdomDetailsByName(kingdomName);

        // Verify the results
        assertTrue(new ReflectionEquals(expectedResult, excludeFields).matches(result));
    }

    @Test
    void testGetKingdomDetailsByName_inputInvalidKingdomName_shouldReturnNoKingdomDetails() {
        // Setup

        final String kingdomName = "INVALID";
        final String excludeFields= null;
        final Kingdom expectedResult = null;

        // Run the test
        final Kingdom result = kingdomServiceImplUnderTest.getKingdomDetailsByName(kingdomName);

        // Verify the results
        assertTrue(new ReflectionEquals(expectedResult, excludeFields).matches(result));
    }

    @Test
    void testDoesMessageContainsKingdomEmblem_validMessage_shouldReturnTrue() {
        // Setup
        final String message = "AJXGAMUTA";
        final String kingdomName = FIRE;
        final Kingdom kingdom = kingdomServiceImplUnderTest.getKingdomDetailsByName(kingdomName);
        // Run the test
        final boolean result = kingdomServiceImplUnderTest.doesMessageContainsKingdomEmblem(message, kingdom);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testDoesMessageContainsKingdomEmblem_invalidMessage_shouldReturnFalse() {
        // Setup
        final String message = "bishal";
        final String kingdomName = FIRE;
        final Kingdom kingdom = kingdomServiceImplUnderTest.getKingdomDetailsByName(kingdomName);
        // Run the test
        final boolean result = kingdomServiceImplUnderTest.doesMessageContainsKingdomEmblem(message, kingdom);

        // Verify the results
        assertFalse(result);
    }
}
