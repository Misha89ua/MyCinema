<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      		
   <div class="container" style="width:40%; border-style: solid; border-color: blue;
   					 border-radius: 20px; background-color: #80d4ff; width: 700px">
      <c:forEach items="${halls}" var="hall">
      <div style="background-color: #cce6ff; border-radius: 10px; margin: 10px; display: flex; justify-content: flex-start;">
          <div style="width: 30%; text-align: center;">
          	<h3>${hall.hallName} </h3>
          </div >
         <div style="width: 50%; padding-left: 15%">
         	<h3> ${hall.numberOfSeats} місць</h3>
         </div>
         
        <sec:authorize access="hasRole ('ROLE_ADMIN')">
	         <div style="display: flex; align-items: center; padding: 10px 0">
	         	<a href="${pageContext.request.contextPath}/admin/hall-delete/${hall.id}">
	         	<button type="button" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" title="Видалити"></span></button>
	         	</a>
	         </div>
         </sec:authorize>
      </div>
      </c:forEach>
   </div>