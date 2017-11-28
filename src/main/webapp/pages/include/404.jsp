<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>404 - 页面不存在</title>
		<link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="/resources/css/ie.css" />" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<div class="span-24 last">
			<h1>
				页面不存在.(404)
			</h1>
			<a href="<c:url value="/"/>">返回首页</a>
		</div>
	</body>
</html>