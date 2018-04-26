<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      		
   <div class="container" style="border-style: solid; border-color: blue;
   					 border-radius: 20px; background-color: #80d4ff; width: 700px">
      <c:forEach items="${films}" var="film">
      <div style="background-color: #cce6ff; border-radius: 10px; margin: 10px; display: flex; justify-content: flex-start;">
         <div >
         	<img width="50px" src="data:image/png; base64, ${film.image}">
         </div>
          <div style="width: 50%; text-align: center;">
          	<h3>${film.filmName}</h3>
         </div >
         <div style="width: 20%; padding-top: 10px">
         	${film.category.val()}
            <br/> ${film.year} р.
            <br /> ${film.movieLength} хв.
            </div>
         <div style="display: flex; align-items: center; padding: 10px 0">
         	<a href="${pageContext.request.contextPath}/user/film-profile/${film.id}">
         	<button type="button" class="btn btn-success btn-xs" style="margin: 5px" title="деталі"><span class="glyphicon glyphicon-eye-open"></span></button>
         	</a>
         	<a href="${pageContext.request.contextPath}/admin/film-edit/${film.id}">
         	<button type="button" class="btn btn-success btn-xs" style="margin: 5px" title="Редагувати"><span class="glyphicon glyphicon-edit"></span></button>
         	</a>
         	<a href="${pageContext.request.contextPath}/admin/film-delete/${film.id}">
         	<button type="button" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" title="Видалити"></span></button>
         	</a>
         </div>
      </div>
      </c:forEach>
   </div>