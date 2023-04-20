<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>

  <body>
    <jsp:include page="../layout/navbar.jsp"></jsp:include>

    <div class="container">
      <div class="row justify-content-center">
        <div class="col-8">
          <h1>Add Message Page</h1>
          <div class="card">
            <div class="card-header">
              Featured
            </div>
            <div class="card-body">
<!--             接收controller所傳的model物件，它叫做messages裡面是一個空的物件，也就是一張空白的畫面，到這個畫面是到addAttribute裡的new Messages的物件，用getText取得他的text屬性，所以才會是空白的畫面，使用者打完字(沒有任何動作)，送出才是setText(path="text")，再到action用method=post回傳給controller -->
<!-- text在Messages裡面有這個變數 -->
              <form:form class="form-control" modelAttribute="messages" method="post" action="${contextRoot}/messages/post">
                <form:textarea path="text" class="form-control" id="" cols="30" rows="10"></form:textarea>
                 <button type="submit"  class="btn btn-primary">送出</button>
              </form:form>
             
            </div>
          </div>
          <br />
				<div class="card">
					<div class="card-header">最新的資料 時間:${latest.added}</div>
					<div class="card-body">
						${latest.text}
						
						
					</div>
				</div>
        </div>
      </div>
    </div>
  </body>

  </html>
