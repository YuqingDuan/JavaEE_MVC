<%--
  Created by IntelliJ IDEA.
  User: Yuqin
  Date: 3/10/2019
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Update Students Page</title>
    </head>
    <body>
        <h3>Update Student</h3>

        <form method="post" action="StoreUpdateInfoServlet">
            <%--sid is needed, why?--%>
            <input type="hidden" name="sid" value="${stu.sid}">
            <table border="1" width="600">
                <tr>
                    <td>name</td>
                    <td><input type="text" name="sname" value=${stu.sname}></td>
                </tr>
                <tr>
                    <td>gender</td>
                    <td>
                        <%--If the gender is male, checked can appear in the male gender input tag, --%>
                        <%--and checked can appear in the female gender input tag if the gender is male.--%>
                        <input type="radio" name="gender" value="male" <c:if test="${stu.gender=='male'}">checked</c:if>>M
                        <input type="radio" name="gender" value="female" <c:if test="${stu.gender=='female'}">checked</c:if>>F
                    </td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td><input type="text" name="phone" value=${stu.phone}></td>
                </tr>
                <tr>
                    <td>birthday</td>
                    <td><input type=" text" name="birthday" value=${stu.birthday}></td>
                </tr>
                <tr>
                    <td>hobby</td>
                    <td>
                        <%--Hobbies: Basketball, Football, Reading--%>
                        <%--Because there are many hobbies, there are included relationships--%>
                        <input type="checkbox" name="hobby" value="swimming"
                               <c:if test="${fn:contains(stu.hobby, 'swimming')}">checked</c:if>>swimming
                        <input type="checkbox" name="hobby" value="basketball"
                               <c:if test="${fn:contains(stu.hobby, 'basketball')}">checked</c:if>>basketball
                        <input type="checkbox" name="hobby" value="football"
                               <c:if test="${fn:contains(stu.hobby, 'football')}">checked</c:if>>football
                        <input type="checkbox" name="hobby" value="reading"
                               <c:if test="${fn:contains(stu.hobby, 'reading')}">checked</c:if>>reading
                        <input type="checkbox" name="hobby" value="writing"
                               <c:if test="${fn:contains(stu.hobby, 'writing')}">checked</c:if>>writing

                    </td>
                </tr>
                <tr>
                    <td>info</td>
                    <td><textarea name="info" rows="3" cols="20">${stu.info}</textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="update"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
