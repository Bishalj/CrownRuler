package geektrust.tameofthrones.main;

import geektrust.tameofthrones.constants.TameOfThronesConstantsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TameOfThronesTests {


    private TameOfThrones tameOfThrones = new TameOfThrones();

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testMain_filePathIsMissing_shouldThrowException(){

        final String[] args = new String[]{TameOfThronesConstantsTest.File.INVALID_PATH};

        assertThrows(IllegalArgumentException.class, () -> TameOfThrones.main(args));
    }

    @Test
    void testMain_validFilePath_shouldPrintAllTheAllyKingdoms() throws Exception {

        final String[] args = new String[]{TameOfThronesConstantsTest.File.VALID_PATH_ONE};
        TameOfThrones.main(args);
    }

    @Test
    void testMain_validFilePathWithLessThan3Allies_shouldPrintNone() throws Exception {

        final String[] args = new String[]{TameOfThronesConstantsTest.File.VALID_PATH_TWO};
        TameOfThrones.main(args);
    }
}
