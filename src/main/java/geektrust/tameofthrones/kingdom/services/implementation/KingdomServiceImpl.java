package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant;
import geektrust.tameofthrones.kingdom.models.Kingdom;
import geektrust.tameofthrones.kingdom.services.KingdomService;
import geektrust.tameofthrones.common.encryption.CipherUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant.FREQUENCY_OF_CHARACTER_IS_ONE;

public class KingdomServiceImpl implements KingdomService {
    private static Map<String, Kingdom> kingdomDetails;

    @Override
    public Kingdom getKingdomDetailsByName(String kingdomName){
        if(kingdomName == null)
            return null;

        String kingdomNameInUpperCase = kingdomName.toUpperCase();
        createKingdomDetailsMapIfNotExists();
        return kingdomDetails.get(kingdomNameInUpperCase);
    }

    @Override
    public boolean doesMessageContainsKingdomEmblem(String message, Kingdom kingdomDetail) {
        final Map<Character, Integer> encryptedEmblemCharacterFrequencyMap = copyEncryptedEmblemMap(kingdomDetail);
        return doesMessageContainsEncryptedEmblem(message, encryptedEmblemCharacterFrequencyMap);
    }

    private void createKingdomDetailsMapIfNotExists() {
        if(kingdomDetails != null)
            return;

        final Map<String, String> kingdomEmblemMap = KingdomDetailsConstant.getKingdomEmblemMap();
        kingdomDetails = kingdomEmblemMap
                .entrySet()
                .parallelStream()
                .map(kingdomEmblem -> getKingdomDetails(kingdomEmblem))
                .collect(Collectors.toMap(kingdom -> kingdom.getName(), kingdom -> kingdom ));
    }

    private boolean doesMessageContainsEncryptedEmblem(String message, Map<Character, Integer> encryptedEmblemCharacterFrequencyMap) {
        for (int index = 0; index < message.length(); index++) {
            char key = message.charAt(index);

            if(isKeyPresentInMap(key, encryptedEmblemCharacterFrequencyMap)){
                if(isFrequencyOfTheCharacterIsOne(encryptedEmblemCharacterFrequencyMap, key))
                    removeTheKeyFromMap(encryptedEmblemCharacterFrequencyMap, key);
                else
                    decrementTheValue(key, encryptedEmblemCharacterFrequencyMap);
            }

            if(encryptedEmblemCharacterFrequencyMap.isEmpty())
                return true;
        }
        return false;
    }

    private boolean isFrequencyOfTheCharacterIsOne(Map<Character, Integer> encryptedEmblemCharacterFrequencyMap, char key) {
        return encryptedEmblemCharacterFrequencyMap.get(key) == FREQUENCY_OF_CHARACTER_IS_ONE;
    }

    private void removeTheKeyFromMap(Map<Character, Integer> encryptedEmblemCharacterFrequencyMap, char key) {
        encryptedEmblemCharacterFrequencyMap.remove(key);
    }

    private boolean isKeyPresentInMap(char key, Map<Character, Integer> map) {
        return map.get(key) != null;
    }

    private HashMap<Character, Integer> copyEncryptedEmblemMap(Kingdom kingdomDetail) {
        return new HashMap(kingdomDetail.getEncryptedEmblemCharactersFrequencyMap());
    }

    private void decrementTheValue(char key, Map<Character, Integer> encryptedFrequencyCountMap) {
        encryptedFrequencyCountMap.put(key, encryptedFrequencyCountMap.get(key) - 1);
    }

    private Kingdom getKingdomDetails(Map.Entry<String, String> kingdomEmblem) {
        final Kingdom kingdom = new Kingdom();
        kingdom.setName(kingdomEmblem.getKey());
        kingdom.setEmblem(kingdomEmblem.getValue());
        mapEncryptedEmblem(kingdomEmblem, kingdom);
        mapEncryptedEmblemCharacterFrequencyMap(kingdom);
        return kingdom;
    }

    private void mapEncryptedEmblemCharacterFrequencyMap(final Kingdom kingdom) {
        final Map<Character, Integer> characterFrequencyCountMap = new HashMap<>();
        final String encryptedEmblem = kingdom.getEncryptedEmblem();
        for (int index = 0; index < encryptedEmblem.length(); index++) {
            char key = encryptedEmblem.charAt(index);
            if(isKeyPresentInMap(key, characterFrequencyCountMap) == false)
                addTheKeyInMapWithFrequencyOne(key, characterFrequencyCountMap);
            else
                incrementTheFrequencyInMap(key, characterFrequencyCountMap);
        }
        kingdom.setEncryptedEmblemCharacterFrequencyMap(characterFrequencyCountMap);
    }

    private void incrementTheFrequencyInMap(char key, Map<Character, Integer> characterFrequencyCountMap) {
        characterFrequencyCountMap.put(key, characterFrequencyCountMap.get(key) + 1);
    }

    private void addTheKeyInMapWithFrequencyOne(char key, Map<Character, Integer> characterFrequencyCountMap) {
        characterFrequencyCountMap.put(key, 1);
    }


    private void mapEncryptedEmblem(Map.Entry<String, String> kingdomEmblem, Kingdom kingdom) {
        final String encryptedEmblem = CipherUtil.encrypt(kingdomEmblem.getValue());
        kingdom.setEncryptedEmblem(encryptedEmblem);
    }
}
