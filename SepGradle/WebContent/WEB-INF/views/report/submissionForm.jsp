<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<title>리포트 제출</title>
</head>
<body>
<h3>@RequestParam사용</h3>

<form action="submitReport1.do" method="post" enctype="multipart/form-data">
<form:errors element="div"/> 
학번 : <input type="text" name="studentNumber"/>
<form:errors path="studentNumber"/>
<br>
리포트 파일 : <input type="file" name="report"/>
<form:errors path="report"/>
<br>
<input type="submit"/>
</form>

<h3>MultipartHttpServletRequest 사용</h3>
<form action="submitReport2.do" method="post" enctype="multipart/form-data">
학번 : <input type="text" name="studentNumber"/>
<form:errors path="studentNumber"/>
<br>
리포트 파일 : <input type="file" name="report"/>
<form:errors path="report"/>
<br>
<input type="submit">
</form>

<h3>커맨드 객체 사용</h3>
<form action="submitReport3.do" method="post" enctype="multipart/form-data">
<form:errors element="div"/> 
학번 : <input type="text" name="studentNumber"/>
<form:errors path="studentNumber"/>
<br>
리포트 파일 : <input type="file" name="report"/>
<form:errors path="report"/>
<br>
<input type="submit"/>
</form>

</body>
</html>