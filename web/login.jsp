<%--
  Created by IntelliJ IDEA.
  User: csap0 -Lyuyk
  Date: 2022/5/25
  Time: 下午 3:06
  FileName: login
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/pages/navigationBar.jsp"/>
<!--jsp:useBean id="loginBean" class="BlogL.Model.userBean" scope="session"/-->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login | BlogL</title>
    <%--    <link href="/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<div align="center">
<div style="width: 300px" >
<form action="<%=request.getContextPath()%>/BlogL/login" method="post">
    <div class="form-group" >
        <label for="user_id">账号</label>
        <input type="text" class="form-control" id="user_id" name="user_id" placeholder="账号">
    </div>
    <div class="form-group">
        <label for="user_password">密码</label>
        <input type="password" class="form-control" name="user_password" id="user_password" placeholder="注意区分大小写">
    </div>
    <div align="right">
        <% String login_error_msg;
            login_error_msg = (String) request.getAttribute("loginErrorMsg");
            if(login_error_msg==null)
                login_error_msg="";
        %>
        <span style="color:red;"><%=login_error_msg%></span>
        <a   href=" " title="忘记密码">忘记密码?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    </div>
    <div align="center">  <button type="submit" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
    </div>
</form>
    <div align="center">  <button type="submit" class="btn btn-primary" onclick="location='<%=request.getContextPath()%>/pages/register.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></div>
</div>
</div>
</body>
</html>
