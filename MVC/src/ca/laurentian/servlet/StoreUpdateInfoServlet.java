package ca.laurentian.servlet;

import ca.laurentian.domain.Student;
import ca.laurentian.service.StudentService;
import ca.laurentian.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class StoreUpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // the data submitted by the client may contain Chinese
        request.setCharacterEncoding("UTF-8");
        try {
            // 1. get the data submitted by the client
            int sid = Integer.parseInt(request.getParameter("sid"));
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String info = request.getParameter("info");
            String[] hobbyArray = request.getParameterValues("hobby");
            // [basketball，football，writing] --- basketball，football，writing
            String hobby = Arrays.toString(hobbyArray);
            hobby = hobby.substring(1, hobby.length() - 1);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            Student student = new Student(sid, sname, gender, phone, date, hobby, info);
            // 2. store the student to database
            StudentService studentService = new StudentServiceImpl();
            studentService.update(student);
            // 3. jump to list.jsp
            request.getRequestDispatcher("StudentListServlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
