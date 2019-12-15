import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class ExampleServ extends HttpServlet {

    private static HashMap<Integer, Stack<Song>> examples;
    private static int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        int id;
        if((counter) >= Integer.MAX_VALUE){
            counter = 0;
        }
        if(request.getParameter("examplesession") == null || request.getParameter("examplesession").equals("")){
            counter++;
            id = counter;
        } else {
            id = Integer.parseInt(request.getParameter("examplesession"));
        }

        if(examples == null){
            examples = new HashMap<>();
        }
        if(examples.get(id) == null || !examples.containsKey(id)){
            Stack<Song> songs = new Stack<>();
            String path = Util.PATH.substring(0, Util.PATH.length()-5) + "Examples";
            File exampleroot = new File(path);
            if (exampleroot.listFiles() != null){
                for (File file : exampleroot.listFiles()){
                    Song song = new Song(file.getName(), file.getAbsolutePath());
                    songs.push(song);
                }
                examples.put(id, songs);
            }
        }

        if(examples.get(id).isEmpty()){
            response.sendRedirect(request.getContextPath()+"/init");
            return;
        }

        String hiddenexmaplesession = "<input type=\"hidden\" name=\"examplesession\" id=\"examplesession\" value=\"" + id + "\">";

        Song currentsong = examples.get(id).pop();
        File[] files = new File(currentsong.getPath()).listFiles();
        Collections.shuffle(Arrays.asList(files));
        String fragmentplayers = "";
        Stack<String> identifiers = new Stack<>();
        identifiers.add("▦");
        identifiers.add("▩");
        identifiers.add("▨");
        for (File fragment : files) {
            String relpath = fragment.getPath().substring(Util.PATHTRIM);
            String url = "http://micksneekes.nl/destisurvey/";
            url += relpath;
            fragmentplayers += ("<li id=" +
                    "\"" + fragment.getName() + "\""+
                    "class=\"ranker\">\n" +
                    "      <p id=\"identifier\">"+
                    identifiers.pop()+
                    "</p>\n" +
                    "      <audio controls controlsList=\"nodownload\">\n" +
                    "        <source src=\"" +
                    url +
                    "\"" +
                    "type=\"audio/mp3\">\n" +
                    "Your browser does not support the audio element."+
                    "      </audio>\n" +
                    "    </li>");
        }

        out.println("<!DOCTYPE html>"+
                "<html>\n" +
                "  <head>\n" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
                "    <title>Staging</title>\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-57x57.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-60x60.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-72x72.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-76x76.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-114x114.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-120x120.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-144x144.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-152x152.png\">\n" +
                "<link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"${pageContext.request.contextPath}/Style/favicon/apple-icon-180x180.png\">\n" +
                "<link rel=\"icon\" type=\"image/png\" sizes=\"192x192\"  href=\"${pageContext.request.contextPath}/Style/favicon/android-icon-192x192.png\">\n" +
                "<link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"${pageContext.request.contextPath}/Style/favicon/favicon-32x32.png\">\n" +
                "<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"${pageContext.request.contextPath}/Style/favicon/favicon-96x96.png\">\n" +
                "<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"${pageContext.request.contextPath}/Style/favicon/favicon-16x16.png\">\n" +
                "<link rel=\"manifest\" href=\"${pageContext.request.contextPath}/Style/favicon/manifest.json\">\n" +
                "<meta name=\"msapplication-TileColor\" content=\"#ffffff\">\n" +
                "<meta name=\"msapplication-TileImage\" content=\"/ms-icon-144x144.png\">\n" +
                "<meta name=\"theme-color\" content=\"#ffffff\">" +
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
                "      Dit nummer is een oefenvraag. <br><br> \n" +
                "      Zet de volgende drie fragmenten op volgorde van hoe goed ze een idee van het nummer geven. Versleep ze op volgorde van de beste naar de minste, waarbij de bovenste de beste is. De symbolen voor de spelers zijn er enkel als herkenningspunt van de fragmenten. Sleep de fragmenten in de gewenste volgorde. \n" +
                "      <br>Het gebruikte nummer is:  " +
                "<span style=\"font-weight: bold\">" +
                currentsong.getTitle()+
                "</span>" +
                " door " +
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
                "  <form action=\"/destisurvey/example\" method=\"get\">\n" +
                "    <input id=\"confirm\" type=\"submit\" value=\"Continue→\">\n" +
                hiddenexmaplesession +
                "  </form>\n" +
                "  <script src=\"JS/sortable.js\"></script>\n" +
                "  </body>\n" +
                "</html>\n"
        );
    }

}
