<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container" style="width: 40%; height:200px; background-color: rgba(0, 120, 201, 0.1); padding: 50px; border-radius: 20px; border-style: solid; border-color: blue ">    
	<form:form modelAttribute="uploadModel" method="POST" action="/admin/upload-film-image" enctype="multipart/form-data">
	
		<div style="margin:20px 0 40px 0">
				<form:input  path="file" type="file"/>
		</div>
		
		<div >
		<input  type="submit" value="Завантажити" class="btn btn-primary btn-xs" >
		</div>
		
		<div style = "display:none">
			<form:input path="userId" cssClass="form-control" title="userId"  />
		</div>

	</form:form>
</div>