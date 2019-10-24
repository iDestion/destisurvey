public class Song {

    private String title;
    private String path;
    private String artist;

    Song(String artisttitle, String path){
        this.artist = artisttitle.split("-")[0];
        this.title = artisttitle.split("-")[1];
        this.path = path;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPath() {
        return this.path;
    }

    public String getArtist() {
        return artist;
    }
}
