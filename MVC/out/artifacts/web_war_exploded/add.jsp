<%--
  Created by IntelliJ IDEA.
  User: Yuqin
  Date: 3/9/2019
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Student Page</title>
    </head>
    <body>
        <h3>Add Student</h3>
        <form method="post" action="AddServlet">
            <table border="1" width="600">
                <tr>
                    <td>name</td>
                    <td><input type="text" name="sname"></td>
                </tr>
                <tr>
                    <td>gender</td>
                    <td>
                        <input type="radio" name="gender" value="male">M
                        <input type="radio" name="gender" value="female">F
                    </td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td>birthday</td>
                    <td><input type="text" name="birthday"></td>
                </tr>
                <tr>
                    <td>hobby</td>
                    <td>
                        <input type="checkbox" name="hobby" value="swimming">swimming
                        <input type="checkbox" name="hobby" value="basketball">basketball
                        <input type="checkbox" name="hobby" value="football">football
                        <input type="checkbox" name="hobby" value="reading">reading
                        <input type="checkbox" name="hobby" value="writing">writing

                    </td>
                </tr>
                <tr>
                    <td>info</td>
                    <td><textarea name="info" rows="3" cols="20"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="add"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
