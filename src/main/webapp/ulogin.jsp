<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head></head>
	<body>
		<form action="${pageContext.request.contextPath}/user/login.mvc">
			用户名：<input name="userLogin" type="text" /><br>
			密码    ：<input name="userPassword" type="text" /><br>
			<input type="submit">
		</form>
	</body>
</html>

