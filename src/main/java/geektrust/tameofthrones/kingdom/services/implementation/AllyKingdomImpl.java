package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import geektrust.tameofthrones.kingdom.models.Kingdom;
import geektrust.tameofthrones.kingdom.services.AllyKingdom;
import geektrust.tameofthrones.kingdom.services.KingdomService;


import java.io.IOException;
import java.util.*;

public class AllyKingdomImpl implements AllyKingdom {

    private final KingdomService kingdomService = new KingdomServiceImpl();

    public Set<String> getAllyKingdoms(final List<KingdomMessageRequest> kingdomMessageRequests, String probableRuler){
        final Set<String> allyKingdoms = getTheAllyKingdomsNameInSet(kingdomMessageRequests, probableRuler);
        return allyKingdoms;
    }

    private Set<String> getTheAllyKingdomsNameInSet(List<KingdomMessageRequest> kingdomMessageRequests, String probableRuler) {
        final Set<String> allyKingdomsNameSet = new LinkedHashSet<>();

        for (KingdomMessageRequest aKingdomMessageRequest : kingdomMessageRequests) {
            if(isKingdomMessageRequestEmpty(probableRuler, aKingdomMessageRequest) ||
                    isKingdomAlreadyBeingProcessdAsAlly(allyKingdomsNameSet, aKingdomMessageRequest))
                continue;

            if(isKingdomAnAlly(aKingdomMessageRequest))
                addKingdomToAllyKingdomsSet(allyKingdomsNameSet, aKingdomMessageRequest);

        }
        return allyKingdomsNameSet;
    }

    private void addKingdomToAllyKingdomsSet(Set<String> allyKingdoms, KingdomMessageRequest aKingdomMessageRequest) {
        String allyKingdomInUpperCase = aKingdomMessageRequest.getKingdomName().toUpperCase();
        allyKingdoms.add(allyKingdomInUpperCase);
    }

    private boolean isKingdomMessageRequestEmpty(String probableRuler, KingdomMessageRequest aKingdomMessageRequest) {
        return isKingdomMessageRequestEmpty(aKingdomMessageRequest) ||
                isKingdomSameAsRuler(aKingdomMessageRequest, probableRuler);
    }

    private boolean isKingdomMessageRequestEmpty(KingdomMessageRequest aKingdomMessageRequest) {
        return  aKingdomMessageRequest == null ||
                aKingdomMessageRequest.getMessage() == null ||
                aKingdomMessageRequest.getKingdomName() == null;
    }

    private boolean isKingdomAlreadyBeingProcessdAsAlly(Set<String> allyKingdoms, KingdomMessageRequest aKingdomMessageRequest) {
        return allyKingdoms.contains(aKingdomMessageRequest.getKingdomName().toUpperCase());
    }

    private boolean isKingdomSameAsRuler(KingdomMessageRequest aKingdomMessageRequest, String probableRuler) {
        return probableRuler.equalsIgnoreCase(aKingdomMessageRequest.getKingdomName());
    }

    private boolean isKingdomAnAlly(KingdomMessageRequest kingdomMessageRequest) {
        final String message = kingdomMessageRequest.getMessage().toUpperCase();
        final String kingdomName = kingdomMessageRequest.getKingdomName();
        final Kingdom kingdomDetail = kingdomService.getKingdomDetailsByName(kingdomName);
        if (kingdomDetail == null)
            return false;

        boolean isKingdomAnAlly = kingdomService.doesMessageContainsKingdomEmblem(message, kingdomDetail);
        return isKingdomAnAlly;
    }


}
