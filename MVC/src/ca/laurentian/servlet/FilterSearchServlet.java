package ca.laurentian.servlet;

import ca.laurentian.domain.Student;
import ca.laurentian.service.StudentService;
import ca.laurentian.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * This servlet is used to process requests to do fuzzy query.
 */
public class FilterSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get the key data "sname" and "sgender" to do fuzzy query
        request.setCharacterEncoding("UTF-8");
        String sname = request.getParameter("sname");
        String sgender = request.getParameter("sgender");

        // 2. use service to do fuzzy query
        StudentService studentService = new StudentServiceImpl();
        try {
            List<Student> studentList = studentService.fuzzyQuery(sname, sgender);

            // 3. store data into request
            request.setAttribute("list", studentList);
            // 4. jump to list.jsp
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
