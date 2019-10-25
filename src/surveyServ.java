import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
@Deprecated
public class surveyServ extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        //TODO add session tracking
        Stack<Song> songs = initServ.getSongs();

        //Stack testing.
//        songs.forEach(k->{
//            System.out.println(k.getName());
//        });

        PrintWriter out = response.getWriter();

        //Handle the input from the last survey page. This servlet always receives input, because the only way to reach it is trough itself, which gives input, or trough initservlet, which provides input.
        FileWriter writer = new FileWriter(Util.OUTPUTPATH + request.getParameter("songname") + ".csv", true);
        String content = "{" + request.getParameter("result") + "}\n";
        writer.write(content);
        writer.flush();
        writer.close();

        if(songs.isEmpty()){
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Thank you!</title>\n" +
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
                    "    <link rel=\"stylesheet\" href=\"Style/CSS/reset.css\">\n" +
                    "    <link rel=\"stylesheet\" href=\"Style/CSS/global.css\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <img src=\"Style/Images/logo.png\" alt=\"Logo Universiteit Utrecht\">\n" +
                    "    <p class=\"question\">\n" +
                    "        A proof of concept \"Thank-you\" page.\n" +
                    "    </p>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
        } else {
            Song currentsong = songs.pop();
            String hiddenTitle = "<input type=\"hidden\" name=\"songname\" id=\"songname\" value=\"" + currentsong.getTitle().replaceAll("\\s","") + "\">";
            String fragmentplayers = "";
            int x = 0;
            Stack<String> identifiers = new Stack<>();
            //Identifiers currently are utf-8 symbols. This tool uses 6 different ones, essentially making the maximum number of fragments per song 6.
            identifiers.add("▤");
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
                        "      <p>" +
                        identifiers.pop() +
                        "</p>" +
                        "      <audio controls>\n" +
                        "        <source src=\"" +
                        relpath+
                        "\"" +
                        "type=\"audio/flac\">\n" +
                        "      </audio>\n" +
                        "    </li>");
            }


            out.println("<html>\n" +
                    "  <head>\n" +
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

                    fragmentplayers +

                    "  </ul>\n" +
                    "\n" +
                    //TODO change the path to the file
                    "  <form action=\"/destisurvey/survey\" method=\"get\">\n" +
                    "    <input type=\"hidden\" name=\"result\" id=\"result\" value=\"\">\n" +
                    hiddenTitle +
                    "    <input id=\"confirm\" type=\"submit\" value=\"Continue→\">\n" +
                    "  </form>\n" +
                    "  <script src=\"JS/sortable.js\"></script>\n" +
                    "  </body>\n" +
                    "</html>\n"
            );
        }
    }
}