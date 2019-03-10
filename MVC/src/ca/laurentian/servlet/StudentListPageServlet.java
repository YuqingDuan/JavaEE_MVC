package ca.laurentian.servlet;

import ca.laurentian.domain.PageBean;
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
 * Responsible for querying all students' information in multiple pages, and then presenting the information to the list.jsp.
 */
public class StudentListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get current page need to be show in the page
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        // 2. get data from database by "currentPage"
        StudentService studentService = new StudentServiceImpl();
        try {
            PageBean<Student> studentPageBean = studentService.findStudentByPage(currentPage);
            // 3. store data into request
            request.setAttribute("studentPageBean", studentPageBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 4. jump to
        request.getRequestDispatcher("list_pages.jsp").forward(request, response);
    }
}
