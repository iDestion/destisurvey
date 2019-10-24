import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class ProofServ extends HttpServlet{
    //Handles post request from the dep.jsp page. This allows for the html/js data to be entered into the Java code.
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("result"));

        //TODO handle results

        response.sendRedirect("dep.jsp");
    }

}
