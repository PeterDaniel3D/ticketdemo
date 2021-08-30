package dat.ticketdemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClassList", urlPatterns = {"/classlist"})
public class ClassList extends HttpServlet {
    
    private List<Student> studentList;
    
    	public void init() throws ServletException
        {
            studentList = new ArrayList<>();
            studentList.add(new Student("Blondie"));
            studentList.add(new Student("Jønke"));
            studentList.add(new Student("Makrel"));
            studentList.add(new Student("Ludvig"));
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("classlist", studentList);
        request.getRequestDispatcher("/classlist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
