package geektrust.tameofthrones.kingdom.constants;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;

import java.util.LinkedHashMap;
import java.util.Map;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.Emblems.*;
import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.Kingdoms.*;

public class KingdomDetailsConstant {

    public final static int MINIMUM_ALLIES_TO_WIN = 3;
    public final static int FREQUENCY_OF_CHARACTER_IS_ONE = 1;
    public final static String PROBABLE_RULER_DOES_NOT_WINS = "NONE";

    public static Map<String, String> getKingdomEmblemMap() {
        return kingdomEmblemMap;
    }

    public class Kingdoms{
        public final static String SPACE = "SPACE";
        public final static String AIR = "AIR";
        public final static String LAND = "LAND";
        public final static String WATER = "WATER";
        public final static String ICE = "ICE";
        public final static String FIRE = "FIRE";
    }

    class Emblems{
        public final static String GORILLA = "GORILLA";
        public final static String PANDA = "PANDA";
        public final static String OCTOPUS = "OCTOPUS";
        public final static String MAMMOTH = "MAMMOTH";
        public final static String OWL = "OWL";
        public final static String DRAGON = "DRAGON";
    }

    public class Delimiter {
        public final static String SPACE = " ";
    }

    private final static Map<String, String> kingdomEmblemMap = new LinkedHashMap<String, String>(){
        {
            put(SPACE, GORILLA);
            put(LAND, PANDA);
            put(WATER, OCTOPUS);
            put(ICE, MAMMOTH);
            put(AIR, OWL);
            put(FIRE, DRAGON);
        }
    };
}
