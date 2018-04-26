<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      		
   <div style="background-color: #b8b894; width: 100%; border-radius:10px; display: flex; justify-content: space-between; align-content: space-between; flex-wrap: wrap; padding: 20px">
      <c:forEach items="${films}" var="film">
      <div style="width: 40%; background-color: #cce6ff; border-radius: 10px; margin: 10px; display: flex; justify-content: flex-start;">
         <div >
	         <a href="${pageContext.request.contextPath}/user/film-profile/${film.id}">
	         	<img style="border-radius: 10px; width: 175px; height: 250px" src="data:image/png; base64, ${film.image}">
	         </a>
         </div>
          <div style="width: 50%; margin-left: 20px">
          	<h3> ${film.filmName}</h3>
         	<br/> категорія: ${film.category.val()}
         	<br/> країна: ${film.country.val()}
            <br/> рік: ${film.year} р.
            <br /> тривалість: ${film.movieLength} хв.
            <br /> <br /> <a href="#" class="btn btn-success btn-xs">
          				<span class="glyphicon glyphicon-thumbs-up"></span> Like <span class="badge">${film.numberOfLikes}</span>
	   				</a>
	   				<a href="#" class="btn btn-danger btn-xs">
          				<span class="glyphicon glyphicon-thumbs-down"></span> Dislike <span class="badge">${film.numberOfDislikes}</span>
        			</a>
            </div>
      </div>
      </c:forEach>
   </div>