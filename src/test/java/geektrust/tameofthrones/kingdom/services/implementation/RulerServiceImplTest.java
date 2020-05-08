package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.constants.TameOfThronesConstantsTest;
import geektrust.tameofthrones.initializer.AllyKingdomInitializer;
import geektrust.tameofthrones.initializer.KingdomMessageRequestInitializer;
import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import geektrust.tameofthrones.kingdom.models.Kingdom;
import geektrust.tameofthrones.kingdom.services.AllyKingdom;
import geektrust.tameofthrones.kingdom.services.KingdomMessageMapper;
import geektrust.tameofthrones.validation.service.FileValidation;
import geektrust.tameofthrones.validation.service.RequestValidation;
import geektrust.tameofthrones.validation.service.implementation.FileValidationImpl;
import geektrust.tameofthrones.validation.service.implementation.RequestValidationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.SPACE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RulerServiceImplTest {

    @InjectMocks
    public RulerServiceImpl rulerServiceImplUnderTest;

    @Mock
    public AllyKingdom allyKingdom;

    @Mock
    public  RequestValidation requestValidation;

    @Mock
    public  FileValidation fileValidation;

    @Mock
    public  KingdomMessageMapper kingdomMessageMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPrintTheRulerDetails_validInputDate_shouldPrintTheRulerDetails() throws Exception {
        // Setup
        final String filePath = TameOfThronesConstantsTest.File.VALID_PATH_ONE;
        final String[] arguments = new String[]{filePath};
        final String probableRuler = SPACE;
        final File file = new File(arguments[0]);
        final List<KingdomMessageRequest> kingdomMessageRequests = KingdomMessageRequestInitializer.getValidKingdomMessageRequest();
        final Set<String> allyKingdomNames = AllyKingdomInitializer.getValidAllyKingdomNamesSet();

        Mockito.when(requestValidation.isFilePathPresent(any()))
                .thenReturn(true);

        Mockito.when(fileValidation.getValidFile(filePath))
                .thenReturn(file);

        Mockito.when(kingdomMessageMapper.getKingdomMessageRequestsFromFile(file))
                .thenReturn(kingdomMessageRequests);

        Mockito.when(allyKingdom.getAllyKingdoms(kingdomMessageRequests,probableRuler))
                .thenReturn(allyKingdomNames);

        // Run the test
        rulerServiceImplUnderTest.printTheRulerDetails(arguments, probableRuler);
    }

    @Test
    void testPrintTheRulerDetails_ThrowsIOException() {
        // Setup
        final String filePath = TameOfThronesConstantsTest.File.INVALID_PATH;
        final String[] arguments = new String[]{filePath};
        final String probableRuler = SPACE;

        Mockito.when(requestValidation.isFilePathPresent(any()))
                .thenReturn(true);

        // Run the test
        assertThrows(IllegalArgumentException.class, () -> {
            rulerServiceImplUnderTest.printTheRulerDetails(arguments, probableRuler);
        });

        verify(fileValidation, never()).getValidFile(filePath);
    }
}
