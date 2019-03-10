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

/**
 * This servlet is used to process requests to update students.
 * Query a student's information according to ID and jump to update.jsp.
 */
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get sid
        int sid = Integer.parseInt(request.getParameter("sid"));
        StudentService studentService = new StudentServiceImpl();
        try {
            // 2. query the student' information
            Student stu = studentService.findStudentById(sid);
            // 3. show date in update.jsp
            request.setAttribute("stu", stu);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
