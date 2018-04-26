<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="container" style="border-style: solid; border-radius: 20px;
					 background-color: #ffe6e6; width: 500px; text-align: center;">
					 
		<h3>Підтвердіть видалення користувача: <br> ${user.firstName} ${user.lastName} <br> ${user.email}</h3>
		<div>
			<a href="${pageContext.request.contextPath}/admin/delete-user-confirm/${user.id}">
			<button type="button" class="btn btn-danger">Підтвердити</button>
			</a>
			<a href="${pageContext.request.contextPath}/admin/users">
			<button type="button" class="btn btn-info">Відміна</button>
			</a>
		</div>     
   </div>