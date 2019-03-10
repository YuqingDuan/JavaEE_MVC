package ca.laurentian.servlet;

import ca.laurentian.service.StudentService;
import ca.laurentian.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet is used to process requests to delete students.
 */
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get the parameter "sid" transferred by JS in list.jsp
        int sid = Integer.parseInt(request.getParameter("sid"));

        StudentService studentService = new StudentServiceImpl();
        try {
            // execute delete operation
            studentService.delete(sid);
            // delete successfully, jump to list.jsp
            request.getRequestDispatcher("StudentListServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
