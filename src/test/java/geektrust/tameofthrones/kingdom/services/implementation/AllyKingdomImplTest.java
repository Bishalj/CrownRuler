package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.initializer.AllyKingdomInitializer;
import geektrust.tameofthrones.initializer.KingdomMessageRequestInitializer;
import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllyKingdomImplTest {

    private AllyKingdomImpl allyKingdomImplUnderTest;

    @BeforeEach
    void setUp() {
        allyKingdomImplUnderTest = new AllyKingdomImpl();
    }

    @Test
    void testGetAllyKingdoms_validInputData_shouldReturnAllAllyKingdomNames(){
        // Setup
        final List<KingdomMessageRequest> kingdomMessageRequests = KingdomMessageRequestInitializer.getValidKingdomMessageRequest();
        final String probableRuler = SPACE;
        final Set<String> expectedResult = AllyKingdomInitializer.getValidAllyKingdomNamesSet();

        // Run the test
        final Set<String> result = allyKingdomImplUnderTest.getAllyKingdoms(kingdomMessageRequests, probableRuler);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllyKingdoms_invalidInputData_shouldReturnNoAllyKingdomNames(){
        // Setup
        final List<KingdomMessageRequest> kingdomMessageRequests = KingdomMessageRequestInitializer.getInvalidKingdomMessageRequest();
        final String probableRuler = SPACE;
        final Set<String> result = allyKingdomImplUnderTest.getAllyKingdoms(kingdomMessageRequests, probableRuler);
        // Run the test
        assertTrue(result.isEmpty());
    }
}
