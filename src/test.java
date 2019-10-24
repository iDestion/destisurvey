import java.io.File;

public class test {
    public static void main(String[] args) {
        File testfile = new File("/music");
        if (testfile.listFiles() != null){
            for (File file : testfile.listFiles()){
                System.out.println(file.getPath());
            }
        }
    }
}
