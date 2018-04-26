<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="container" style="border-style: solid; border-radius: 20px;
					 background-color: #ffe6e6; width: 500px; text-align: center;">
					 
		<h3>Підтвердіть видалення залу: <br> ${hall.hallName}</h3>
		<div>
			<a href="${pageContext.request.contextPath}/admin/hall-delete-confirm/${hall.id}">
			<button type="button" class="btn btn-danger">Підтвердити</button>
			</a>
			<a href="${pageContext.request.contextPath}/user/halls">
			<button type="button" class="btn btn-info">Відміна</button>
			</a>
		</div>     
   </div>