<%--
  Created by IntelliJ IDEA.
  User: csap0 -Lyuyk
  Date: 2022/5/28
  Time: 上午 10:41
  FileName: register
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<jsp:include page="/pages/navigationBar.jsp"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>register | BlogL</title>
</head>
<body>
<div align="center">
    <div style="width: 300px" >
        <form action="<%=request.getContextPath()%>/BlogL/register" method="post">
            <div class="form-group" >
                <label for="user_name">昵称</label>
                <input type="text" class="form-control" id="user_name" name="user_name" placeholder="昵称">
            </div>
            <div class="form-group">
                <label for="user_password">密码</label>
                <input type="password" class="form-control" name="user_password" id="user_password" placeholder="注意区分大小写">
            </div>
            <div class="form-group">
                <label for="user_password_check">确认密码</label>
                <input type="password" class="form-control" name="user_password_check" id="user_password_check" placeholder="注意区分大小写">
            </div>
            <div class="form-group">
                <label for="user_email">邮箱</label>
                <input type="password" class="form-control" name="user_email" id="user_email" placeholder="输入常用邮箱">
            </div>
            <div align="right">
                <% String login_error_msg;
                    login_error_msg = (String) request.getAttribute("loginErrorMsg");
                    if(login_error_msg==null)
                        login_error_msg="";
                %>
                <span style="color:red;"><%=login_error_msg%></span>
            </div>
        </form>
        <div align="center">  <button type="submit" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></div>
    </div>
</div>
</body>
</html>
