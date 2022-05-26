<%--
  Created by IntelliJ IDEA.
  User: csap0 -Lyuyk
  Date: 2022/5/25
  Time: 下午 4:17
  FileName: test
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%
String driverName="com.mysql.cj.jdbc.Driver";
String userName="root";
//密码
String userPassword="NewPassword";
//数据库名
String dbName="blog";
//表名
String tableName="testtable";

String url="jdbc:mysql://localhost:3306/"+dbName+"?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true&user="+userName+"&password="+userPassword;
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection conn=DriverManager.getConnection(url);
Statement stmt = conn.createStatement();
String sql="SELECT * FROM "+tableName;
ResultSet rs = stmt.executeQuery(sql);
out.print("id");
out.print("|");
out.print("name");
out.print("<br>");
while(rs.next()) {
    out.print(rs.getString(1)+" ");
    out.print("|");
    out.print(rs.getString(2)+" ");
    out.print("<br>");
}
out.print("<br>");
out.print("ok， Database Query Successd！");
rs.close();
stmt.close();
conn.close();
%>

<html>
<head>
    <title>Sql</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/RUNOOB?useUnicode=true&characterEncoding=utf-8"
                   user="root"  password="NewPassword"/>
</body>
</html>
