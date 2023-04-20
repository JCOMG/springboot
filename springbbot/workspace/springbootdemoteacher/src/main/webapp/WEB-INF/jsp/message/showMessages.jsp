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
			<jstl:forEach var="pageNumber" begin="1" end="${page.totalPages}">
				  <jstl:choose>
				     <jstl:when test="${page.number != pageNumber-1 }">
				          <a href="${contextRoot}/messages?p=${pageNumber}">${pageNumber}</a>
				     </jstl:when>
				     <jstl:otherwise>
				            ${pageNumber}
				     </jstl:otherwise>
				  
				  </jstl:choose>
			
				  <jstl:if test="${pageNumber != page.totalPages }">
				    -
				  </jstl:if>
			
			
			</jstl:forEach>
 </div>
 </div>
 </div>
</body>
</html>