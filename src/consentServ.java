import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consentServ extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("consent").equals("noconsent")){
            response.sendRedirect("noconsentnl.jsp");
        } else if (request.getParameter("consent").equals("consent")){
            //TODO redirect to example questions, not the survey itself
            response.sendRedirect(request.getContextPath() + "/example");
        } else if (request.getParameter("consent").equals("noconsenten")){
            response.sendRedirect("noconsenten.jsp");
        } else if(request.getParameter("consent").equals("consenten")){
            //TODO redirect to example questions, not the survey itself
            response.sendRedirect(request.getContextPath() + "/exampleen");
        }
        //TODO create initen and noconsenten
    }

}
