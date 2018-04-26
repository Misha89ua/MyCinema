<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="container" style="width: 50%; background-color: rgba(0, 120, 201, 0.1); padding: 50px; border-radius: 20px; border-style: solid; border-color: blue ">    
	<form:form modelAttribute="userProfileEditor" method="POST" action="/${userProfileEditor.var}/edit-user" enctype="multipart/form-data">
		
		<div class="form-group">
			<form:errors path="*" cssClass="error"/>
		</div>
		
		<div style="display: none;">
		<label class="control-label">e-mail</label>
		<form:input path="email" cssClass="form-control" title="e-mail" />
		</div>
		
		<br>
		<div style="display: flex; justify-content:space-between;">
		<div>
		<label class="control-label">Прізвище</label>
		<form:input path="lastName" cssClass="form-control" title="Прізвище" />
		</div>
		
		<div>
		<label class="control-label">Ім'я</label>
		<form:input path="firstName" cssClass="form-control" title="Ім'я" />
		</div>
		</div>
		
		<br>
 		<label class="control-label">Дата народження</label>
 		<div style="display: flex; justify-content: flex-start;">
	 		<div>
				<form:select path="dateOfBirdthDay" cssClass="form-control">
					<c:forEach begin="1" end="31" var="a">
						<form:option value="${a}">${a}</form:option>
					</c:forEach>
				</form:select>	
			</div>
			<div>	
				<form:select path="dateOfBirdthMonth" cssClass="form-control">
					<c:forEach begin="1" end="12" var="a">
						<form:option value="${a}">${a}</form:option>
					</c:forEach>
				</form:select>	
			</div>
			<div>	
				<form:select path="dateOfBirdthYear" cssClass="form-control">
					<c:forEach begin="1900" end="2050" var="a">
						<form:option value="${a}">${a}р</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<br><br>
		<div class="form-group">
			<span class="input-group-btn">
				<input type="submit" class="btn btn-primary" value="Зберегти">
			</span>
		</div>
	</form:form>
</div>