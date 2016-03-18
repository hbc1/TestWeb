<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
</head>
<body>
	登录名： ${user.userLogin}<br>
	<a href="${pageContext.request.contextPath}/user/loginOut.mvc">退出</a>
</body>
</html>