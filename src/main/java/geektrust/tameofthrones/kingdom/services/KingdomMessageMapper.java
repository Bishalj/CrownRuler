package geektrust.tameofthrones.kingdom.services;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface KingdomMessageMapper {

    List<KingdomMessageRequest> getKingdomMessageRequestsFromFile(File inputFile) throws IOException;
}
