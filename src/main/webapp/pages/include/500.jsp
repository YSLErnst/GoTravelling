<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request
				.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>500 - 系统内部错误</title>
		<link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="/resources/css/ie.css" />" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<div class="span-24 last">
			<h1>
				系统发生内部错误.(500)
			</h1>
			<a href="<c:url value="/"/>">返回首页</a>
		</div>
	</body>
</html>
