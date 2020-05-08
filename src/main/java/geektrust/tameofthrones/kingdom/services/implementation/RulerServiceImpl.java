package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import geektrust.tameofthrones.kingdom.services.AllyKingdom;
import geektrust.tameofthrones.kingdom.services.KingdomMessageMapper;
import geektrust.tameofthrones.kingdom.services.RulerService;
import geektrust.tameofthrones.validation.service.FileValidation;
import geektrust.tameofthrones.validation.service.RequestValidation;
import geektrust.tameofthrones.validation.service.implementation.FileValidationImpl;
import geektrust.tameofthrones.validation.service.implementation.RequestValidationImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.MINIMUM_ALLIES_TO_WIN;
import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.PROBABLE_RULER_DOES_NOT_WINS;

public class RulerServiceImpl implements RulerService {

    private AllyKingdom allyKingdom = new AllyKingdomImpl();
    private final RequestValidation requestValidation = new RequestValidationImpl();
    private final FileValidation fileValidation = new FileValidationImpl();
    private final KingdomMessageMapper kingdomMessageMapper= new KingdomMessageMapperImpl();

    public void printTheRulerDetails(String[] arguments, String probableRuler) throws IOException {
        File inputFile = getValidFile(arguments);
        final List<KingdomMessageRequest> kingdomMessageRequests = kingdomMessageMapper.getKingdomMessageRequestsFromFile(inputFile);
        final Set<String> allyKingdomsName = allyKingdom.getAllyKingdoms(kingdomMessageRequests, probableRuler);
        printTheRulerDetails(probableRuler, allyKingdomsName);
    }

    private File getValidFile(String arguments[]) {
        if(isFilePathNotPresent(arguments))
            throw new IllegalArgumentException("Please enter the path of the input file");
        final String filePath = arguments[0];
        return fileValidation.getValidFile(filePath);
    }

    private boolean isFilePathNotPresent(String[] arguments) {
        return requestValidation.isFilePathPresent(arguments) == false;
    }

    private void printTheRulerDetails(String probableRuler, Set<String> allyKingdomsName) {
        if(isProbableRulerWins(allyKingdomsName)) {
            System.out.print(probableRuler);
            printAllTheAllyKingdoms(allyKingdomsName);
        }else
            System.out.println(PROBABLE_RULER_DOES_NOT_WINS);
    }

    private boolean isProbableRulerWins(Set<String> allyKingdomsName) {
        return allyKingdomsName != null && allyKingdomsName.size() >= MINIMUM_ALLIES_TO_WIN;
    }

    private static void printAllTheAllyKingdoms(Set<String> allyKingdomsName) {
        for (String anAllyKingdomName : allyKingdomsName)
            System.out.print(" " + anAllyKingdomName);
        System.out.println();
    }

}
