<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<a href="hello.do">/hello.do</a>
<br>  

<!-- <a href="hello.do">
-> http://localhost:8088/SepGradle/hello.do
<a href="/hello.do">
-> http://localhost:8088/hello.do = > hello.do라는 파일을 찾음 -->

<a href="article/newArticle.do">/article/newArticle.do</a> <br>

<a href="order/order.do">/order.do</a><br>

<a href="search/internal.do?query=aa & p=1">/internal.do</a> <a href="search/external.do">/external.do</a><br>

<a href="cookie/make.do">/make.do</a>  <a href="cookie/view.do">/view.do</a><br>

<a href="header/check.do">/check.do</a> <br>

<a href="search/main.do">game</a> <br>

<a href="game/users/ha/characters/0506">/game/users/{1}/characters/{2}</a>
<br>
<a href="account/create.do">/create</a><br>

<a href="login/login.do"> /login</a> <br>

<a href="report/submission.do"> report</a> <br>

<a href="log/query.do"> query</a> <br>

<a href="event/list.do"> event</a> <br>

<a href="math/add.do?op2=3">add</a> <a href="math/subtract.do?op2=2">subtract</a>
<a href="math/multiply.do?op1=10">multiply</a> <a href="math/divide.do?op1=&op2=0">divide</a> <br>

<a href="test/simpleTest.do">simpleTest</a> <a href="test/simpleTest1.do">simpleTest1</a> <a href="test/simpleTest2.do">simpleTest2</a>


</body>
</html>