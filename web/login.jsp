<%--
  Created by IntelliJ IDEA.
  User: csap0 -Lyuyk
  Date: 2022/5/25
  Time: 下午 3:06
  FileName: login
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loginBean" class="BlogL.Model.userBean" scope="session"/>
<html>
<head>
    <title>login | BlogL</title>
</head>
<body>
    <font size=2>
        <div align="center">
            <table border=2>
                <tr>
                    <th>
                        login
                    </th>
                </tr>
                <table action="loginServlet" method="post">
                    <tr>
                        <td>
                            Username<input type="text" name="userName">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password<input type="password" name="password">
                        </td>
                    </tr>
                </table>
                <input type="submit" name="g" value="提交">
                </form>
            </table>
        </div>
    </font>
</body>
</html>
