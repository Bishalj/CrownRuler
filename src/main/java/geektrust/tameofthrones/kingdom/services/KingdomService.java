package geektrust.tameofthrones.kingdom.services;

import geektrust.tameofthrones.kingdom.models.Kingdom;

import java.util.Map;

public interface KingdomService {

    Kingdom getKingdomDetailsByName(String kingdomName);
    boolean doesMessageContainsKingdomEmblem(String message, Kingdom kingdomDetail);
}
