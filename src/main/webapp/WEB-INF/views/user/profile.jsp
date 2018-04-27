<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container" style="width: 50%; height:500px; background-color: #cce6ff; border-radius: 20px">
        
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 200px; width: 106%; margin-left: -3%; border-radius: 20px 20px 0 0; background-color:#3399ff">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
    
    	<div class="item active">
		  <div style="width: 90%; height:300px; border-radius: 20px; display: flex">
		        
		    <div style="margin-left: 25%; width: 200px">                    
		            <div>
		           		 <h1>${film0.filmName}</h1>
		            </div>
		            <div>
			          	<br/> категорія: ${film0.category.val()}
			         	<br/> країна: ${film0.country.val()}
			            <br/> рік: ${film0.year} р.
			            <br /> тривалість: ${film0.movieLength} хв.
		            </div>
		            
			</div>    
			<div style="display:flex; flex-direction: column"> 
		    	<br>        
		        <img style="width: 120px; border-radius: 10px" src="data:image/png; base64, ${film0.image}" alt="Profile image"/>
		
		    </div> 
		</div> 
      </div>
    
		<div class="item">
		  <div style="width: 90%; height:300px; border-radius: 20px; display: flex">
		        
		    <div style="margin-left: 25%; width: 200px">                    
		            <div>
		           		 <h1>${film1.filmName}</h1>
		            </div>
		            <div>
			          	<br/> категорія: ${film1.category.val()}
			         	<br/> країна: ${film1.country.val()}
			            <br/> рік: ${film1.year} р.
			            <br /> тривалість: ${film1.movieLength} хв.
		            </div>
		            
			</div>    
			<div style="display:flex; flex-direction: column"> 
		    	<br>        
		        <img style="width: 120px; border-radius: 10px" src="data:image/png; base64, ${film1.image}" alt="Profile image"/>
		
		    </div> 
		</div> 
      </div>
      
      <div class="item">
		  <div style="width: 90%; height:300px; border-radius: 20px; display: flex">
		        
		    <div style="margin-left: 25%; width: 200px">                    
		            <div>
		           		 <h1>${film2.filmName}</h1>
		            </div>
		            <div>
			          	<br/> категорія: ${film2.category.val()}
			         	<br/> країна: ${film2.country.val()}
			            <br/> рік: ${film2.year} р.
			            <br /> тривалість: ${film2.movieLength} хв.
		            </div>
		            
			</div>    
			<div style="display:flex; flex-direction: column"> 
		    	<br>        
		        <img style="width: 120px; border-radius: 10px" src="data:image/png; base64, ${film2.image}" alt="Profile image"/>
		
		    </div> 
		</div> 
      </div>
      
      <div class="item">
		  <div style="width: 90%; height:300px; border-radius: 20px; display: flex">
		        
		    <div style="margin-left: 25%; width: 200px">                    
		            <div>
		           		 <h1>${film3.filmName}</h1>
		            </div>
		            <div>
			          	<br/> категорія: ${film3.category.val()}
			         	<br/> країна: ${film3.country.val()}
			            <br/> рік: ${film3.year} р.
			            <br /> тривалість: ${film3.movieLength} хв.
		            </div>
		            
			</div>    
			<div style="display:flex; flex-direction: column"> 
		    	<br>        
		        <img style="width: 120px; border-radius: 10px" src="data:image/png; base64, ${film3.image}" alt="Profile image"/>
		
		    </div> 
		</div> 
      </div>
      
    </div>
    <!-- Left and right controls -->
    <a style="border-radius: 20px 0 0 0" class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a style="border-radius: 0 20px 0 0" class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  
  
  
  
  
  <div style="display: flex;">
    <div style="margin:50px 30px 0px 25px; height:120px">         
        		<img style="width: 140px; border-radius: 50%" align="left"  src="data:image/png; base64, ${userProfile.image}" alt="Profile image"/>
    </div>
    <div style="margin:50px 0px 0px 50px; display: flex; flex-direction: column; align-items: center;">                    
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
		    <li><a href="/user/upload-image">картинку</a></li>
		    <li><a href="/user/edit-user">дані профілю</a></li>
		    </ul>
		</div>
	</div>
 </div>       
</div> <!-- /container -->  