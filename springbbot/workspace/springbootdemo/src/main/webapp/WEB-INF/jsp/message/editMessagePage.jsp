<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改頁面</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-8">
				<h1>修改頁面</h1>
				<div class="card">
					<div class="card-header">訊息</div>
					<div class="card-body">
<!-- 					model.addAttribute("messages",msg);要跟MessageController的"messages"一樣 -->
						<form:form class="form-control" modelAttribute="messages"
							method="put" action="${contextRoot}/messages/edit">
							<form:input type="hidden" path="id"/>
							<!-- 原生的form表單只會送GET、POST表單，但這裡用的是Spring的form表單，所以可使用method="put" -->
							<!-- name=id type=hidden是為了要讓後端知道id是什麼，否則會跑出500錯誤資訊無法接收null -->
							<form:textarea path="text" class="form-control" id="" cols="30"
								rows="10"></form:textarea>
							<button type="submit" class="btn btn-primary">送出</button>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
