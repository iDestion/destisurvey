import java.io.File;
import java.util.Stack;

public class MusicController {

    private String path;

    public MusicController(String path){
        this.path = path;
    }

    public Stack<Song> returnFiles(){
        File musicroot = new File(path);
        Stack<Song> songList = new Stack<>();
        if (musicroot.listFiles() != null){
            for (File file : musicroot.listFiles()){
                System.out.println(file.getName() + "   " + file.getPath());
                Song song = new Song(file.getName(), file.getAbsolutePath());
                songList.add(song);
            }
        }
        return songList;
    }
}
