<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title><spring:message code="login.form.title" /></title>
<!-- 지정해둔 messageSource의 지정해둔 프로퍼티파일 에서 message를 가져옴 login.form.title라는 key값을 가진 message! -->

</head>
<body>

	<form:form commandName="login">
		<!-- 메서드의 기본 전송방식 : post / 액션 : 현재 url다시 요청-->
		<!-- form:form 태그는 항상 commond객체가 있어야 한다. (@ModelAttribute사용해서 커맨드 객체 전송될수 있도록!) 
	commandName : 커맨드객체의 key값 / command라는 이름으로 가져오면 지정안해줘도 된다. -->

		<form:errors />
		<!-- 에러 지정안해줬으므로 global에러 -> reject()를 통해 -->

		<p>
			<label for="loginType"><spring:message code="login.form.type" /></label>
			<form:select path="loginType" items="${loginTypes}" />
			<!-- option의 내용이 모델데이터에 저장되어있기 때문에 일일히 지정하면 불편
	path : 커맨드 객체의 이름 / items <option>태그 컬렉션 객체
	form:select태그는 다른 <option>을 추가할 수 없다. => form:options
	<option>태그의 value값을 따로 지정하고 싶을 때에는 form:option  -->
		</p>

		<p>
			<label for="id"><spring:message code="login.form.id" /></label>
			<form:input id="id" path="id" />
			<!-- path속성에 id : id / name값을 id로 지정 value = login이라는 커맨드객체의 id값 (비어있는 상태)
	=	<input id="id" name="id" type="text" value> -->

			<form:errors path="id" />
			<!-- errors속성에 path : 해당 필드가 가지고 있는 에러코드 출력 -->
		</p>

		<p>
			<label for="password"><spring:message
					code="login.form.password" /></label>
			<form:input id="password" path="password" />
			<form:errors path="password" />
		</p>

		<p>   
			<input type="submit"
				value="<spring:message code="login.form.submit"/>">
			<!-- form taglib에서 submit버튼 지원안함 -->
		</p>

	</form:form>
</body>
</html>