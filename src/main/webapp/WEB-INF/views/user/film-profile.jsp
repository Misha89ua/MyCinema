<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container" style="width: 90%; height:500px; background-color: #cce6ff; padding: 30px; border-radius: 20px; display: flex; ">
        
    <div style="display:flex; flex-direction: column; align-items: center;"> 
    	<br>        
        <img style="width: 200px; border-radius: 10px" src="data:image/png; base64, ${filmRequest.image}" alt="Profile image"/>
			
		<div>
        	<a style="width: 98px" href="#" class="btn btn-success btn-sm">
        	<span class="glyphicon glyphicon-thumbs-up"></span> Like <span class="badge">${filmRequest.numberOfLikes}</span>
	   		</a>
	   		<a style="width: 98px" href="#" class="btn btn-danger btn-sm">
        	<span class="glyphicon glyphicon-thumbs-down"></span> Dislike <span class="badge">${filmRequest.numberOfDislikes}</span>
    		</a>
    	</div>	
    	<sec:authorize access="hasRole ('ROLE_ADMIN')">
	    	<div class="btn-group">
				<a style="width: 200px" href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">редагувати  <span class="caret"></span></a>
			 	<ul class="dropdown-menu">
			    <li><a href="/admin/upload-film-image/${filmRequest.id }">картинку</a></li>
			    <li><a href="${pageContext.request.contextPath}/admin/film-edit/${filmRequest.id}">дані фільму</a></li>
			    </ul>
			</div>	
		</sec:authorize>
    </div>
    <div style="margin-left: 5%; width: 200px">                    
            <div>
           		 <h1>${filmRequest.filmName}</h1>
            </div>
            <div>
	          	<br/> категорія: ${filmRequest.category.val()}
	         	<br/> країна: ${filmRequest.country.val()}
	            <br/> рік: ${filmRequest.year} р.
	            <br /> тривалість: ${filmRequest.movieLength} хв.
            </div>
            
	</div> 
	<div style="margin-left: 5%; width: 80%">
		<h3>Опис фільму:</h3>
		<br><br>
		${filmRequest.filmDescription}
	</div>      
</div> <!-- /container -->  