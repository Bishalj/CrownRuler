package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.initializer.KingdomMessageRequestInitializer;
import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static geektrust.tameofthrones.constants.TameOfThronesConstantsTest.File.INVALID_PATH;
import static geektrust.tameofthrones.constants.TameOfThronesConstantsTest.File.VALID_PATH_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingdomMessageMapperImplTest {

    private KingdomMessageMapperImpl kingdomMessageMapperImplUnderTest;

    @BeforeEach
    void setUp() {
        kingdomMessageMapperImplUnderTest = new KingdomMessageMapperImpl();
    }

    @Test
    void testGetKingdomMessageRequestsFromFile() throws Exception {
        // Setup
        final File inputFile = new File(VALID_PATH_ONE);
        final List<KingdomMessageRequest> expectedResult = KingdomMessageRequestInitializer.getValidKingdomMessageRequest();

        // Run the test
        final List<KingdomMessageRequest> result = kingdomMessageMapperImplUnderTest.getKingdomMessageRequestsFromFile(inputFile);
        assertEquals(expectedResult.size(), result.size());

        List<KingdomMessageRequest> kingdomMessageRequests =
                expectedResult
                    .parallelStream()
                    .filter(kingdomMessageRequest -> !isKingdomMessageRequestPresentInList(result, kingdomMessageRequest))
                    .collect(Collectors.toList());
        assertTrue(kingdomMessageRequests == null || kingdomMessageRequests.isEmpty());
    }

    private boolean isKingdomMessageRequestPresentInList(List<KingdomMessageRequest> result, KingdomMessageRequest kingdomMessageRequest) {
        Optional<KingdomMessageRequest> kingdomMessageRequestResult =
                result
                    .parallelStream()
                    .filter(kingdomMessageData-> areBothTheObjectsSame(kingdomMessageData, kingdomMessageRequest) )
                    .findAny();

        return kingdomMessageRequestResult.isPresent();
    }

    private boolean areBothTheObjectsSame(KingdomMessageRequest kingdomMessageData, KingdomMessageRequest kingdomMessageRequest) {
        boolean areBothObjectSame =  kingdomMessageData.getKingdomName().equalsIgnoreCase(kingdomMessageRequest.getKingdomName()) &&
                kingdomMessageData.getMessage().equalsIgnoreCase(kingdomMessageRequest.getMessage());
        return areBothObjectSame;
    }

    @Test
    void testGetKingdomMessageRequestsFromFile_ThrowsIOException() throws Exception {
        // Setup
        final File inputFile = new File(INVALID_PATH);

        // Run the test
        assertThrows(IOException.class, () -> {
            kingdomMessageMapperImplUnderTest.getKingdomMessageRequestsFromFile(inputFile);
        });
    }
}
