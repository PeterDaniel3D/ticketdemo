package dat.ticketdemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "WaitingList", urlPatterns = {"/waitinglist"})
public class WaitingList extends HttpServlet {

    private List<Student> waitingList = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/waitinglist.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String command = request.getParameter("command");
                
        switch(command) {
            case "add":
                waitingList.add(new Student(request.getParameter("requestname")));
                break;
                
            case "remove":
                if (waitingList.size() > 0) {
                    waitingList.remove(0);                    
                }
                break;
        }
        session.setAttribute("waitinglist", waitingList);
        
        request.getRequestDispatcher("/waitinglist.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
