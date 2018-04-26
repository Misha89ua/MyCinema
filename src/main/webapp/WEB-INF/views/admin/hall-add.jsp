<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="container" style="width: 30%; background-color: #cce6ff; padding: 20px; border-radius: 20px; border-style: solid; border-color: blue ">    
	<form:form modelAttribute="hallRequest" method="POST" action="/admin/hall-add" enctype="multipart/form-data">
		
		<div class="form-group">
			<form:errors path="*" cssClass="error"/>
				<c:if test="${error != null}">
					<span class = "error">"${error}"</span>
				</c:if>
					</div>
		
		<div class="form-group">
			<label class="control-label">Назва залу</label>
			<form:input path="hallName" cssClass="form-control" title="Назва фільму" />
		</div>
		<div>
			<label class="control-label">Кількість місць</label>
			<form:select path="numberOfSeats" cssClass="form-control" cssStyle="width:100px">
				<c:forEach begin = "10" end = "100" var="c">
					<form:option value="${c}">${c}</form:option>
				</c:forEach>
			</form:select>	
		</div>
		
		<div class="form-group" style="text-align: center;">
			<br><br>
			<span class="input-group-btn">
				<input type="submit" class="btn btn-primary" value="Зберегти">
			</span>
		</div>
	</form:form>
</div>