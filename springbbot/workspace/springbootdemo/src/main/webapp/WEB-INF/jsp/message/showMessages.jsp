<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Message Page</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">
		<div class="row justify-content-center">
			<div class="col-8">
              <h1>Show Message Page</h1>
<!--               items是集合可以放很多的資料 
					這裡的page.content是用page這個物件裡面的content屬性放進message裡面，message才可以拿到裡面的值也就是存放進資料庫裡面的值-->
              <jstl:forEach var="message" items="${page.content}">
              <div class="card">
					<div class="card-header">新增時間: <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${message.added}"/></span></div>
					<div class="card-body">
						${message.text}
						<p />
						<div style="display:flex">
						<form action="${contextRoot}/messages/edit">
						   <input type="hidden" name="id" value="${message.id}" />
						   <input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
						</form>
<!-- 							這裡是原生的form表單，所以只能用POST或GET -->
						<form action="${contextRoot}/messages/delete" method="post">
						   <input type="hidden" name="_method" value="delete" />
						   <input type="hidden" name="id" value="${message.id}" />
						   <input type="submit" class="btn btn-outline-danger btn-sm" value="刪除" />
						</form>
						</div>
					</div>
				</div>
			</jstl:forEach>
			<br />
<!-- 			用到page裡面的屬性totalPages這個屬性，這個就是說總共有幾頁，ex:總共有3頁，那最後一頁就是第3頁 -->
			<jstl:forEach var="pageNumber" begin="1" end="${page.totalPages}">
<!-- 			這裡的var="pageNumber"想像成是int i =1 ，page.number一開始是從0開始，pageNumber一開始是從1開始，所以前者+1或+1 -->
			     <jstl:choose>
			     <jstl:when test="${page.number != pageNumber-1 }">
			          <a href="${contextRoot}/messages?p=${pageNumber}">${pageNumber}</a>
			     </jstl:when>
			     <jstl:otherwise>
			            ${pageNumber}
			     </jstl:otherwise>
			  
			  </jstl:choose>
			
			</jstl:forEach>
 </div>
 </div>
 </div>
</body>
</html>
