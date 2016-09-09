<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<title>로그인</title>
</head>
<body>

	<form:form commandName = "loginCommand">
<!-- 	form:form 커스텀태그는 메서드전송방식이 기본이 post -->
		
		<form:errors element="div"/> 
		<!--글로벌 에러 / div태그를 써서 에러메시지를 출력하겠다 -->
		
		아이디 : <form:input path="userId" />
		<%-- <form:input path="userId"/> -> <input id="userId" name="userId" type="text" value="">
		path명이 id와 name명으로  --%>
		<form:errors path="userId"/> 
		<!-- userId에 대한 에러 div태그로 에러메시지 출력 : 아래줄 -->
		<br>
		
		암호 : <form:password path="password" showPassword="false"/>
		<form:errors path="password"/>
		<!-- password에 대한 에러 span태그로 에러메시지 출력 : 옆줄 -->
		<br>
		
		<input type="submit"/>
	</form:form>	
</body>
</html>