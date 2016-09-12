<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<title>로그 목록</title>
</head>
<body>

<form:form method="get">
<form:errors path="from" element="div"/>
<form:errors path="to" element="div"/>
시작일 : <form:input path="from"/>
종료일 : <form:input path="to"/>
<input type="submit" value="조회"/>
</form:form>
</body>
</html>