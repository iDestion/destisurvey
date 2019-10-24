import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Stack;

public class initServ extends HttpServlet {

    private MusicController controller;
    private static Stack songs;

    public static Stack getSongs() {
        return songs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Init the controller, song list and randomize it.
        this.controller = new MusicController(Util.PATH);
        songs = controller.returnFiles();
        Collections.shuffle(songs);


        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Song currentsong = (Song) songs.pop();
        String hiddenName = "<input type=\"hidden\" name=\"songname\" id=\"songname\" value=\"" + currentsong.getTitle().replaceAll("\\s","") + "\">";
        String fragmentplayers = "";
        int x = 0;
        Stack<String> identifiers = new Stack<>();
        //Identifiers currently are utf-8 symbols. This tool currently uses 6 different ones, essentially making the maximum number of fragments per song 6.
        identifiers.add("&#9640");
        identifiers.add("▧");
        identifiers.add("▥");
        identifiers.add("▦");
        identifiers.add("▩");
        identifiers.add("▨");
        for (File fragment : new File(currentsong.getPath()).listFiles()) {
            x++;
            String relpath = fragment.getPath().substring(Util.PATHTRIM);
            fragmentplayers += ("<li id=" +
                    "\"fragment" + x + "\""+
                    "class=\"ranker\">\n" +
                    "      <p id=\"identifier\">"+
                    identifiers.pop()+
                    "</p>\n" +
                    "      <audio controls>\n" +
                    "        <source src=\"" +
                    relpath +
                    "\"" +
                    "type=\"audio/flac\">\n" +
                    "      </audio>\n" +
                    "    </li>");
        }



        out.println("<html>\n" +
                "  <head>\n" +
                "<meta charset=\"UTF-8\">" +
                "    <title>Staging</title>\n" +
                "\n" +
                "    <!-- CSS sheets -->\n" +
                "      <link rel=\"stylesheet\" href=\"Style/CSS/reset.css\">\n" +
                "      <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap\" rel=\"stylesheet\">\n" +
                "      <link rel=\"stylesheet\" href=\"Style/CSS/global.css\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "\n" +
                "\n" +
                "  <!-- Load in the necessary JS scripts for the sortable list -->\n" +
                "  <script src=\"JS/jquery.js\"></script>\n" +
                "  <script src=\"JS/jquery-ui.js\"></script>\n" +
                "  <script src=\"JS/jquery-ui-touch.js\"></script>\n" +
                "\n" +
                "  <img src=\"Style/Images/logo.png\" alt=\"Logo Universiteit Utrecht\">\n" +
                "  \n" +
                "  <p class=\"question\">\n" +
                "      This is an example question, purely used as a proof of context. The top fragment is the most representative, the bottom one the least. Music snippets do not belong to me.\n" +
                "      <br>The song used is " +

                "<span style=\"font-weight: bold\">" +
                currentsong.getTitle()+
                "</span>" +
                " by " +
                "<span style=\"font-weight: bold\">" +
                currentsong.getArtist() +
                "</span>" +

                ".\n" +
                "  </p>\n" +
                "\n" +
                "  <ul id=\"image-list1\" class=\"sortable-list\">\n" +

                fragmentplayers+

                "  </ul>\n" +
                "\n" +
                //TODO change the path to the file
                "  <form action=\"/destisurvey/survey\" method=\"get\">\n" +
                "    <input type=\"hidden\" name=\"result\" id=\"result\" value=\"\">\n" +
                hiddenName+
                "    <input id=\"confirm\" type=\"submit\" value=\"Continue→\">\n" +
                "  </form>\n" +
                "  <script src=\"JS/sortable.js\"></script>\n" +
                "  </body>\n" +
                "</html>\n"
        );


    }
}