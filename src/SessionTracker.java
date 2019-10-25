import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class SessionTracker {

    public static Map<String, Stack<Song>> mapping = new HashMap<>();

    public static void storeSession(String id, Stack<Song> stack){
        mapping.put(id, stack);
    }

    public static Stack<Song> sessionLookup(String id){
        if(mapping.containsKey(id)){
            return mapping.get(id);
        }
        //If no mapping was found, create a new entry in the mapping and return a newly generated stack of songs.
        Stack<Song> templist = MusicController.returnFiles();
        mapping.put(id, templist);
        return templist;
    }


    //Method to generate random string with the bounds defined in Util
    public static String generateToken(Random random, String characters, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

}
