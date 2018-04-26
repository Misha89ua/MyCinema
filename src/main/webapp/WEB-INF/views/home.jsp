<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
    
      
      <div class="item active">
		  <div style="width: 90%; height:300px; margin-left: 5%; border-radius: 20px; display: flex; ">
		        
		    <div style="display:flex; flex-direction: column; align-items: center; margin-top:-13px"> 
		    	<br>        
		        <img style="width: 200px; border-radius: 10px" src="data:image/png; base64, ${film1.image}" alt="Profile image"/>
		
		    </div>
		    <div style="margin-left: 5%; width: 200px">                    
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
			<div style="margin-left: 5%; width: 80%">
				<h3>Опис фільму:</h3>
				<br><br>
				${film1.filmDescription}
			</div>      
		</div> 
      </div>
      
      <div class="item">
		  <div style="width: 90%; height:300px; margin-left: 5%; border-radius: 20px; display: flex; ">
		        
		    <div style="display:flex; flex-direction: column; align-items: center; margin-top:-13px"> 
		    	<br>        
		        <img style="width: 200px; border-radius: 10px" src="data:image/png; base64, ${film2.image}" alt="Profile image"/>
		
		    </div>
		    <div style="margin-left: 5%; width: 200px">                    
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
			<div style="margin-left: 5%; width: 80%">
				<h3>Опис фільму:</h3>
				<br><br>
				${film2.filmDescription}
			</div>      
		</div> 
      </div>
      
      <div class="item">
		  <div style="width: 90%; height:300px; margin-left: 5%; border-radius: 20px; display: flex; ">
		        
		    <div style="display:flex; flex-direction: column; align-items: center; margin-top:-13px"> 
		    	<br>        
		        <img style="width: 200px; border-radius: 10px" src="data:image/png; base64, ${film3.image}" alt="Profile image"/>
		
		    </div>
		    <div style="margin-left: 5%; width: 200px">                    
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
			<div style="margin-left: 5%; width: 80%">
				<h3>Опис фільму:</h3>
				<br><br>
				${film3.filmDescription}
			</div>      
		</div> 
      </div>
      
      
    
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" style="border-radius: 20px 0 0 20px" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" style="border-radius: 0 20px 20px 0" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div><br><br></div>

<div class="panel panel-default">
  <div class="panel-body">
    <div class="row">
   		<div class="col-md-10 col-md-offset-1">
    		What is Lorem Ipsum?
Lorem Ipsum is simply пррактика text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

   		</div> 		
    </div>
  </div>
</div>