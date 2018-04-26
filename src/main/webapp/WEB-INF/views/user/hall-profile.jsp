<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container" style="width: 40%; height:150px; background-color: #cce6ff;
                             padding: 20px; border-radius: 20px; border-style:solid; display: flex; flex-direction: column; justify-content: center">                   
            <div>
           		 <h1>${hallRequest.hallName}</h1>
            </div>
            <div>
	          	<br/> кількість місць: ${hallRequest.numberOfSeats}
            </div>
             
</div> <!-- /container -->  