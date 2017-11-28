<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@ page pageEncoding="UTF-8"%>
<title>管理员页面</title>
</head>
<body>
这是管理员页面,欢迎您<sec:authentication property="name"/>!<br/>
<br/>
<p>All Rights Reserved By Ernst</p>
</body>
</html> 