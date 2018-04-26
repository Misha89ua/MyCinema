<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      		
   <div class="container" style="border-style: solid; border-color: blue;
   					 border-radius: 20px; background-color: #80d4ff; width: 700px">
      <c:forEach items="${users}" var="user">
      <div style="background-color: #cce6ff; border-radius: 10px; margin: 10px; display: flex; justify-content: flex-start;">
         <div >
         	<img width="100px" src="data:image/png; base64, ${user.image}">
         </div>
          <div style="width: 30%; text-align: center;">
          	<h3>${user.firstName} <br> ${user.lastName}</h3>
          </div >
         <div style="width: 40%; padding-top: 10px">
         	<p> <i class="glyphicon glyphicon-envelope"></i> ${user.email}
            <br/> <i class="glyphicon glyphicon-certificate"></i> ${user.age} років
            <br /> <i class="glyphicon glyphicon-gift"></i> ${user.dateOfBirdth}</p>
         </div>
         <div style="display: flex; align-items: center; padding: 10px 0">
         	<a href="${pageContext.request.contextPath}/admin/user-profile/${user.id}">
         	<button type="button" class="btn btn-success btn-xs" style="margin: 5px" title="Редагувати"><span class="glyphicon glyphicon-edit"></span></button>
         	</a>
         	<a href="${pageContext.request.contextPath}/admin/delete-user/${user.id}">
         	<button type="button" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" title="Видалити"></span></button>
         	</a>
         </div>
      </div>
      </c:forEach>
   </div>