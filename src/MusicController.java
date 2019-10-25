import java.io.File;
import java.util.Stack;

public class MusicController {

    private static String path = Util.PATH;

    public static Stack<Song> returnFiles(){
        File musicroot = new File(path);
        Stack<Song> songList = new Stack<>();
        if (musicroot.listFiles() != null){
            for (File file : musicroot.listFiles()){
                Song song = new Song(file.getName(), file.getAbsolutePath());
                songList.add(song);
            }
        }
        return songList;
    }
}
