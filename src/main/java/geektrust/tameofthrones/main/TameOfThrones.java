package geektrust.tameofthrones.main;

import geektrust.tameofthrones.kingdom.services.RulerService;
import geektrust.tameofthrones.kingdom.services.implementation.RulerServiceImpl;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.Kingdoms.SPACE;


public class TameOfThrones {

    private static RulerService rulerService = new RulerServiceImpl();

    public static void main(String[] arguments) throws Exception {
        final String PROBABLE_RULER = SPACE;
        rulerService.printTheRulerDetails(arguments, PROBABLE_RULER);
    }
}
