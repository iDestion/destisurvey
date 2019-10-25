import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

public class getresultServ extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resultsradio = request.getParameter("resultsradio");
        //TODO save in local var
        if(resultsradio.equals("resultno")){
            //Redirect to the final thank you page.
            response.sendRedirect("finish.jsp");
            return;
        } else if (resultsradio.equals("resultyes")){

            //Store the e-mail adress of users that would like the results of the paper.
            FileWriter writer = new FileWriter(Util.OUTPUTPATH + "email.csv");
            String content = "{" + request.getParameter("email") + "}\n";
            writer.write(content);
            writer.flush();
            writer.close();
            //Redirect to the final thank you page.
            response.sendRedirect("finish.jsp");
            return;
        }
    }
}
