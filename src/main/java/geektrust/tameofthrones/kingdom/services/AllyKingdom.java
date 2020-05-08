package geektrust.tameofthrones.kingdom.services;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;

import java.util.List;
import java.util.Set;

public interface AllyKingdom {
    Set<String> getAllyKingdoms(List<KingdomMessageRequest> kingdomMessageRequests, String probableRuler);
}
