package geektrust.tameofthrones.kingdom.constants;

import geektrust.tameofthrones.kingdom.models.Kingdom;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Kingdoms.*;
import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstantTests.Emblems.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingdomDetailsConstantTests {

    @Test
    public void testGetKingdomEmblemMap_validInputData_shouldReturnValidKingdomEmblemMap(){
        assertEquals(KingdomDetailsConstant.getKingdomEmblemMap(), kingdomEmblemMap);
    }

    public class Kingdoms{
        public final static String SPACE = "SPACE";
        public final static String AIR = "AIR";
        public final static String LAND = "LAND";
        public final static String WATER = "WATER";
        public final static String ICE = "ICE";
        public final static String FIRE = "FIRE";
    }

    public class Emblems{
        public final static String GORILLA = "GORILLA";
        public final static String PANDA = "PANDA";
        public final static String OCTOPUS = "OCTOPUS";
        public final static String MAMMOTH = "MAMMOTH";
        public final static String OWL = "OWL";
        public final static String DRAGON = "DRAGON";
    }

    public static Kingdom getKingdomDetailsByName(String kingdomName){
        final Map<String, Kingdom> kingdomDetails = getKingdomDetailsMap();
        return kingdomDetails.get(kingdomName);
    }

    private final static Map<String, String> kingdomEmblemMap = new LinkedHashMap(){
        {
            put(SPACE, GORILLA);
            put(LAND, PANDA);
            put(WATER, OCTOPUS);
            put(ICE, MAMMOTH);
            put(AIR, OWL);
            put(FIRE, DRAGON);
        }
    };

    private static Map<String, Kingdom> getKingdomDetailsMap() {

        final Map<String, Kingdom> kingdomDetails = new HashMap<>();
        Kingdom spaceKingdom = new Kingdom();
        spaceKingdom.setName(SPACE);
        spaceKingdom.setEmblem(kingdomEmblemMap.get(spaceKingdom.getName()));
        spaceKingdom.setEncryptedEmblem("NVYPSSH");
        mapEncryptedEmblemCharacterFrequencyMap(spaceKingdom);

        Kingdom landKingdom = new Kingdom();
        landKingdom.setName(LAND);
        landKingdom.setEmblem(kingdomEmblemMap.get(landKingdom.getName()));
        landKingdom.setEncryptedEmblem("UFSIF");
        mapEncryptedEmblemCharacterFrequencyMap(landKingdom);

        Kingdom waterKingdom = new Kingdom();
        waterKingdom.setName(WATER);
        waterKingdom.setEmblem(kingdomEmblemMap.get(waterKingdom.getName()));
        waterKingdom.setEncryptedEmblem("VJAVWBZ");
        mapEncryptedEmblemCharacterFrequencyMap(waterKingdom);

        Kingdom iceKingdom = new Kingdom();
        iceKingdom.setName(ICE);
        iceKingdom.setEmblem(kingdomEmblemMap.get(iceKingdom.getName()));
        iceKingdom.setEncryptedEmblem("THTTVAO");
        mapEncryptedEmblemCharacterFrequencyMap(iceKingdom);

        Kingdom airKingdom = new Kingdom();
        airKingdom.setName(AIR);
        airKingdom.setEmblem(kingdomEmblemMap.get(airKingdom.getName()));
        airKingdom.setEncryptedEmblem("RZO");
        mapEncryptedEmblemCharacterFrequencyMap(airKingdom);

        Kingdom fireKingdom = new Kingdom();
        fireKingdom.setName(FIRE);
        fireKingdom.setEmblem(kingdomEmblemMap.get(fireKingdom.getName()));
        fireKingdom.setEncryptedEmblem("JXGMUT");
        mapEncryptedEmblemCharacterFrequencyMap(fireKingdom);

        kingdomDetails.put(SPACE, spaceKingdom);
        kingdomDetails.put(LAND, landKingdom);
        kingdomDetails.put(WATER, waterKingdom);
        kingdomDetails.put(ICE, iceKingdom);
        kingdomDetails.put(AIR, airKingdom);
        kingdomDetails.put(FIRE, fireKingdom);
        return kingdomDetails;
    }

    private static void mapEncryptedEmblemCharacterFrequencyMap(final Kingdom kingdom) {
        final Map<Character, Integer> characterFrequencyCountMap = new HashMap<>();
        final String encryptedEmblem = kingdom.getEncryptedEmblem();

        for (int index = 0; index < encryptedEmblem.length(); index++) {
            char key = encryptedEmblem.charAt(index);
            if(isKeyPresentInMap(characterFrequencyCountMap, key)) {
                addKeyWithValueOne(characterFrequencyCountMap, key);
            } else {
                incrementTheValueByOne(characterFrequencyCountMap, key);
            }
        }
        kingdom.setEncryptedEmblemCharacterFrequencyMap(characterFrequencyCountMap);
    }

    private static boolean isKeyPresentInMap(Map<Character, Integer> characterFrequencyCountMap, char key) {
        return characterFrequencyCountMap.get(key) == null;
    }

    private static void addKeyWithValueOne(Map<Character, Integer> characterFrequencyCountMap, char key) {
        characterFrequencyCountMap.put(key, 1);
    }

    private static void incrementTheValueByOne(Map<Character, Integer> characterFrequencyCountMap, char key) {
        characterFrequencyCountMap.put(key, characterFrequencyCountMap.get(key) + 1);
    }
}
