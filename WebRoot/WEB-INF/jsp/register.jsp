<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/register.action" method="post">
username:<input type="text" name="userLogin.login_name" /><br>
password:<input type="text" name="userLogin.login_password"/><br>
真实姓名：<input type="text" name="userCustom.username"/><br>
<input type="submit" value="注册"/>

</form>
<font color="red">
<c:if test="${register_err!=null}">
错误信息：${register_err}
</c:if>
<c:if test="${allError!=null}">
错误信息：<br>
<c:forEach var="error" items="${ allError}"  >
 ${error.defaultMessage}<br>
</c:forEach>
</c:if>
</font>

</body>
</html>