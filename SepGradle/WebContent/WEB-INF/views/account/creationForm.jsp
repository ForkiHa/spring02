<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<title>계정 생성</title>
</head>
<body>
<spring:hasBindErrors name="command"/>
<form:errors path="command"/>
<form method="post">
	아이디 : <input type="text" name="id" value="${command.id}"/>
	<form:errors path="command.id"/>
	<br/> 
	이름: <input type="text" name="name" value="${command.name}"/>
	<form:errors path="command.name"/>
	<br/> 
	우편번호 :<input type="text" name="address.zipcode" value="${command.address.zipcode}"/>
	<form:errors path="command.address.zipcode"/>
	<!-- address.zipcode : address객체안에 있는 zipcode프로퍼티에 저장 -->
	<br/> 
	주소1: <input type="text" name="address.address1" value="${command.address.address1}"/>
	<form:errors path="command.address.address1"/>
	<br/> 
	주소 2: <input type="text" name="address.address2" value="${command.address.address2}"/>
	<form:errors path="command.address.address2"/>
	<br/> 
	<input type="submit"/>

</form>
</body>
</html>