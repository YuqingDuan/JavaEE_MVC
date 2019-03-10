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
 * Responsible for querying all students' information, and then presenting the information to the list.jsp.
 */
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // find all students' information
            StudentService studentService = new StudentServiceImpl();
            List<Student> list = studentService.findAll();

            // store students list into request
            request.setAttribute("list", list);

            // jump to another page
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
