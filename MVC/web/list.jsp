<%--
  Created by IntelliJ IDEA.
  User: Yuqin
  Date: 3/9/2019
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Students List Page</title>

        <script type="text/javascript">
            function doDelete(sid) {
                // If the dialog box pops up here and the user clicks OK, he or she immediately requests the Servlet.
                // How to know what the user clicks is OK?
                // How to request servlet in a JS method?
                var flag = confirm("Are you sure to delete?");
                if (flag) {
                    // indicate that you have clicked OK, access the servlet, and open a hyperlink on the current tab
                    // window.location.href = "DeleteServlet?sid=" + sid;
                    location.href = "DeleteServlet?sid=" + sid;
                }
            }
        </script>
    </head>
    <body>
        <form action="FilterSearchServlet" method="post">
            <table border="1" width="700">
                <tr>
                    <td colspan="8">
                        filter by name: <input type="text" name="sname">
                        &nbsp;
                        filter by gender: <select name="sgender">
                        <option value="">--select--</option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>
                        &nbsp;&nbsp;&nbsp;
                        <input type="submit" value="filter">
                        &nbsp;&nbsp;&nbsp;
                        <a href="add.jsp">add</a>
                    </td>
                </tr>

                <tr align="center">
                    <td>id</td>
                    <td>name</td>
                    <td>gender</td>
                    <td>phone</td>
                    <td>birthday</td>
                    <td>hobby</td>
                    <td>info</td>
                    <td>operation</td>
                </tr>

                <c:forEach items="${list}" var="stu">
                    <tr align="center">
                        <td>${stu.sid}</td>
                        <td>${stu.sname}</td>
                        <td>${stu.gender}</td>
                        <td>${stu.phone}</td>
                        <td>${stu.birthday}</td>
                        <td>${stu.hobby}</td>
                        <td>${stu.info}</td>
                        <td>
                            <a href="UpdateServlet?sid=${stu.sid}">update</a> <a href="#"
                                                                                 onclick="doDelete(${stu.sid})">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
