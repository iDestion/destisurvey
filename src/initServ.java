import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Stack;

public class initServ extends HttpServlet {

    private static Stack songs;

    public static Stack getSongs() {
        return songs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Generate new Session ID, to be stored in the static mapping in the sessiontracker, if there is none apparent already
        String id = request.getParameter("session");
        if(id == null || id.equals("")) {
            //Session, generated from a combination of the current datetime and a secure random string
            id = LocalDateTime.now() + "--" + SessionTracker.generateToken(new SecureRandom(), Util.sessionBounds, 15);
        }
        //list generated from the session tracker, which will return a new list in this case, no session for this user should exist
        songs = SessionTracker.sessionLookup(id);
        Collections.shuffle(songs);


        //Write the results to a file. Only when the parameter is not null or empty --> there are results to be written.
        if (request.getParameter("result") != null && !request.getParameter("result").equals("")) {
            FileWriter writer = new FileWriter(Util.OUTPUTPATH + request.getParameter("songname") + ".csv", true);
            String content = "{" + request.getParameter("result") + "}\n";
            writer.write(content);
            writer.flush();
            writer.close();
        }

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // if the songs stack is empty, the user with the current session has completed every question defined in the system. Send him/her to a thank you page.
        if(songs.isEmpty()){
            response.sendRedirect("thankyou.jsp");
            return;
        }

        Song currentsong = (Song) songs.pop();
        String hiddenName = "<input type=\"hidden\" name=\"songname\" id=\"songname\" value=\"" + currentsong.getTitle().replaceAll("\\s","") + "\">";
        String hiddenSession = "<input type=\"hidden\" name=\"session\" id=\"session\" value=\"" + id + "\">";
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
                    "\"" + fragment.getName() + "\""+
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
                "      Sleep de fragmenten in de juiste volgorde. De bovenste geeft het beste idee van het nummer, de onderste het slechtste.\n" +
                "      <br>Het gebruikte nummer is " +

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
                "  <form action=\"/destisurvey/init\" method=\"get\">\n" +
                "    <input type=\"hidden\" name=\"result\" id=\"result\" value=\"\">\n" +
                hiddenName+
                hiddenSession+
                "    <input id=\"confirm\" type=\"submit\" value=\"Continue→\">\n" +
                "  </form>\n" +
                "  <script src=\"JS/sortable.js\"></script>\n" +
                "  </body>\n" +
                "</html>\n"
        );


    }
}