<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container" style="width: 50%; height:500px; background-color: #cce6ff; padding: 10px; border-radius: 20px ">
        
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 200px">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
		<h1>KLIP_1</h1>
      </div>
      
      <div class="item">
		<h1>KLIP_2</h1>
      </div>
    
      <div class="item">
        <h1>KLIP_3</h1>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div>
  
  
    <div style="margin:-45px 0px 0px 25px; width: 20%;height:120px">         
        		<img width="140px" align="left" src="data:image/png; base64, ${userProfile.image}" alt="Profile image"/>
    </div>
    <div style="margin:-90px 0px 0px 0px;margin-left: 33%">                    
            <div>
           		 <h1>${userProfile.firstName} ${userProfile.lastName}</h1>
            </div>
            <div>
          	  <p> <i class="glyphicon glyphicon-envelope"></i> ${userProfile.email}
                <br/> <i class="glyphicon glyphicon-certificate"></i> ${userProfile.age} років
                <br /> <i class="glyphicon glyphicon-gift"></i> ${userProfile.dateOfBirdth} р.
                </p>
            </div>
            <div class="btn-group">
		  <a href="#" class="btn btn-primary btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">редагувати  <span class="caret"></span></a>
		  <ul class="dropdown-menu">
		    <li><a href="/admin/upload-user-image/${userProfile.id}">картинку</a></li>
		    <li><a href="/admin/edit-user/${userProfile.id}">дані профіл</a></li>
		    </ul>
		</div>
	</div>
 </div>       
</div> <!-- /container -->  