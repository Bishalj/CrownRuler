package geektrust.tameofthrones.common.encryption;

public class CipherUtil {

    public static String encrypt(String value){
        final int NUMBER_OF_ROTATION = value.length();
        final char CHARACTER_A = 'A';
        final int NUMBER_OF_ALPHABETS = 26;
        final StringBuffer encryptedString = new StringBuffer();

        for(int index=0; index<value.length(); index++){
            char currentCharacter = value.charAt(index);
            int moveNumberOfCharactersPosition = (currentCharacter + NUMBER_OF_ROTATION - CHARACTER_A) % NUMBER_OF_ALPHABETS;
            char encryptedCharacter =(char)(CHARACTER_A + moveNumberOfCharactersPosition);
            encryptedString.append(encryptedCharacter);
        }
        return encryptedString.toString();
    }

}
