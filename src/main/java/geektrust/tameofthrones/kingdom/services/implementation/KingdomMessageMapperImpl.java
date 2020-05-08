package geektrust.tameofthrones.kingdom.services.implementation;

import geektrust.tameofthrones.kingdom.constants.KingdomDetailsConstant;
import geektrust.tameofthrones.kingdom.mappers.KingdomMessageRequest;
import geektrust.tameofthrones.kingdom.services.KingdomMessageMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KingdomMessageMapperImpl implements KingdomMessageMapper {

    @Override
    public List<KingdomMessageRequest> getKingdomMessageRequestsFromFile(File inputFile) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        final List<KingdomMessageRequest> kingdomMessageRequests = getKingdomMessageRequests(bufferedReader);
        return kingdomMessageRequests;
    }

    private List<KingdomMessageRequest> getKingdomMessageRequests(BufferedReader bufferedReader) throws IOException {
        final List<KingdomMessageRequest> kingdomMessageRequests = new ArrayList<>();
        mapKingdomMessageRequests(bufferedReader, kingdomMessageRequests);
        return kingdomMessageRequests;
    }

    private void mapKingdomMessageRequests(BufferedReader bufferedReader, List<KingdomMessageRequest> kingdomMessageRequests) throws IOException {
        String individualRowData;
        while ((individualRowData = bufferedReader.readLine()) != null) {
            final KingdomMessageRequest kingdomMessageRequest = getKingdomMessageRequest(individualRowData);
            if(isKingdomMessageRequestValid(kingdomMessageRequest))
                kingdomMessageRequests.add(kingdomMessageRequest);
        }
    }

    private boolean isKingdomMessageRequestValid(KingdomMessageRequest kingdomMessageRequest ) {
        return kingdomMessageRequest != null;
    }

    private KingdomMessageRequest getKingdomMessageRequest(String individualRowData) {
        final int indexOfFirstSpace = individualRowData.indexOf(KingdomDetailsConstant.Delimiter.SPACE);
        if(indexOfFirstSpace == -1)
            return null;
        final String kingdom = getTheKingdomName(individualRowData, indexOfFirstSpace);
        final String message = getTheMessage(individualRowData, indexOfFirstSpace);
        final KingdomMessageRequest kingdomMessageRequest = new KingdomMessageRequest(kingdom, message);
        return kingdomMessageRequest;
    }

    private String getTheMessage(String individualRowData, int indexOfFirstSpace) {
        return individualRowData.substring(indexOfFirstSpace+1);
    }

    private String getTheKingdomName(String individualRowData, int indexOfFirstSpace) {
        final int STARTING_INDEX = 0;
        return individualRowData.substring(STARTING_INDEX, indexOfFirstSpace);
    }
}
