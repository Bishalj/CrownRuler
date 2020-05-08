package geektrust.tameofthrones.initializer;

import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;

import java.util.ArrayList;
import java.util.List;

public class KingdomMessageRequestInitializer {

    public static List<KingdomMessageRequest> getValidKingdomMessageRequest(){
        List<KingdomMessageRequest> kingdomMessageRequests = new ArrayList<>();

        KingdomMessageRequest kingdomMessageRequest1 = new KingdomMessageRequest();
        kingdomMessageRequest1.setKingdomName("LANd");
        kingdomMessageRequest1.setMessage("fdixxsokkofbbmu");

        KingdomMessageRequest kingdomMessageRequest2 = new KingdomMessageRequest();
        kingdomMessageRequest2.setKingdomName("ICE");
        kingdomMessageRequest2.setMessage("MOMA MVTMTMHTM");

        KingdomMessageRequest kingdomMessageRequest3 = new KingdomMessageRequest();
        kingdomMessageRequest3.setKingdomName("WATER");
        kingdomMessageRequest3.setMessage("SUMMER IS COMING");

        KingdomMessageRequest kingdomMessageRequest4 = new KingdomMessageRequest();
        kingdomMessageRequest4.setKingdomName("AIR");
        kingdomMessageRequest4.setMessage("OWLAOWLBOWLC");

        KingdomMessageRequest kingdomMessageRequest5= new KingdomMessageRequest();
        kingdomMessageRequest5.setKingdomName("FIRE");
        kingdomMessageRequest5.setMessage("AJXGAMUTA");

        kingdomMessageRequests.add(kingdomMessageRequest1);
        kingdomMessageRequests.add(kingdomMessageRequest2);
        kingdomMessageRequests.add(kingdomMessageRequest3);
        kingdomMessageRequests.add(kingdomMessageRequest4);
        kingdomMessageRequests.add(kingdomMessageRequest5);
        return kingdomMessageRequests;
    }

    public static List<KingdomMessageRequest> getInvalidKingdomMessageRequest(){
        List<KingdomMessageRequest> kingdomMessageRequests = new ArrayList<>();

        KingdomMessageRequest kingdomMessageRequest1 = new KingdomMessageRequest();
        kingdomMessageRequest1.setKingdomName("LANding");
        kingdomMessageRequest1.setMessage("fdixxsokkofbbmu");

        KingdomMessageRequest kingdomMessageRequest2 = new KingdomMessageRequest();
        kingdomMessageRequest2.setKingdomName(null);
        kingdomMessageRequest2.setMessage("MOMA MVTMTMHTM");

        KingdomMessageRequest kingdomMessageRequest3 = new KingdomMessageRequest();
        kingdomMessageRequest3.setKingdomName("WATER");
        kingdomMessageRequest3.setMessage(null);

        KingdomMessageRequest kingdomMessageRequest4 = new KingdomMessageRequest();
        kingdomMessageRequest4.setMessage(null);
        kingdomMessageRequest4.setMessage(null);

        KingdomMessageRequest kingdomMessageRequest5= new KingdomMessageRequest();
        kingdomMessageRequest5.setKingdomName("SPACE");
        kingdomMessageRequest5.setMessage("AJXGAMUTA");

        kingdomMessageRequests.add(kingdomMessageRequest1);
        kingdomMessageRequests.add(kingdomMessageRequest2);
        kingdomMessageRequests.add(kingdomMessageRequest3);
        kingdomMessageRequests.add(kingdomMessageRequest4);
        kingdomMessageRequests.add(kingdomMessageRequest5);
        return kingdomMessageRequests;
    }

}