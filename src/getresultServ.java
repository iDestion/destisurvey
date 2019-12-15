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
            response.sendRedirect("finishnl.jsp");
            return;
        } else if(resultsradio.equals("resultnoen")){
            response.sendRedirect("finishen.jsp");
        } else if(resultsradio.equals("resultyesen")){
            //Store the e-mail adress of users that would like the results of the paper.
            FileWriter writer = new FileWriter(Util.OUTPUTPATH + "email.csv", true);
            String content = "{" + request.getParameter("email") + ", English" + "}\n";
            writer.write(content);
            writer.flush();
            writer.close();
            //Redirect to the final english thank you page.
            response.sendRedirect("finishen.jsp");
            return;
        }

        else if (resultsradio.equals("resultyes")){

            //Store the e-mail adress of users that would like the results of the paper.
            FileWriter writer = new FileWriter(Util.OUTPUTPATH + "email.csv", true);
            String content = "{" + request.getParameter("email") + ", Dutch" + "}\n";
            writer.write(content);
            writer.flush();
            writer.close();
            //Redirect to the final dutch thank you page.
            response.sendRedirect("finishnl.jsp");
            return;
        }
    }
}
