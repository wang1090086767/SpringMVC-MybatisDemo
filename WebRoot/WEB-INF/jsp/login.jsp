<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body>
<h2>用户登录</h2>
<br>
<form action="${pageContext.request.contextPath}/login.action " method="post">
username:<input type="text" name="username"/><br>
<br>
password:<input type="password" name ="password"/><br>
<input type="submit" value="登陆">
</form>

</body>
</html>