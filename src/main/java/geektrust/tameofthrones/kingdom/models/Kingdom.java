package geektrust.tameofthrones.kingdom.models;

import java.util.Map;

public class Kingdom {

    private String name;
    private String emblem;
    private String encryptedEmblem;
    private Map<Character, Integer> encryptedEmblemCharacterFrequencyMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getEncryptedEmblem() {
        return encryptedEmblem;
    }

    public void setEncryptedEmblem(String encryptedEmblem) {
        this.encryptedEmblem = encryptedEmblem;
    }

    public Map<Character, Integer> getEncryptedEmblemCharactersFrequencyMap() {
        return encryptedEmblemCharacterFrequencyMap;
    }

    public void setEncryptedEmblemCharacterFrequencyMap(Map<Character, Integer> encryptedEmblemCharacterFrequencyMap) {
        this.encryptedEmblemCharacterFrequencyMap = encryptedEmblemCharacterFrequencyMap;
    }
}
