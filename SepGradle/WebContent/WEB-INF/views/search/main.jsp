<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>게임 검색 메인</title>
</head>
<body>

인기 키워드 :
<c:forEach var="popularQuery" items="${popularQueryList}">
	${popularQuery}
 </c:forEach>
 <form action="game.do">
 	<!-- get방식으로 전송 -->
 	<select name="type">
 		<c:forEach var="searchType" items="${searchTypeList}">
 			<option value="${searchType.code}">${searchType.text}</option>
 		<!-- 	${searchType.code} -> searchType클래스에 getCode() 호출
 			=> view에서 보여줄값이 있으면 getter 필수! -->
 		</c:forEach>	
 	</select>
 	<input type="text" name="query" value=""/>
 	<input type="submit" value="검색"/>
 </form>
</body>
</html>