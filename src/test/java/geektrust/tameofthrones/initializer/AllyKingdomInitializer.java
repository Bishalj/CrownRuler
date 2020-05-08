package geektrust.tameofthrones.initializer;

import geektrust.tameofthrones.kingdom.models.Kingdom;

import java.util.HashSet;
import java.util.Set;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.*;

public class AllyKingdomInitializer {

    public static Set<String> getValidAllyKingdomNamesSet(){
        Set<String> allyKingdoms = new HashSet<>();
        allyKingdoms.add(LAND);
        allyKingdoms.add(ICE);
        allyKingdoms.add(FIRE);
        return allyKingdoms;
    }
}
