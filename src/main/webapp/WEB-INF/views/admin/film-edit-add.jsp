<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="container" style="width: 50%; background-color: #cce6ff; padding: 40px; border-radius: 20px; border-style: solid; border-color: blue ">    
	<form:form modelAttribute="filmRequest" method="POST" action="/admin/film/${filmRequest.var}" enctype="multipart/form-data">
		
		<div class="form-group">
			<form:errors path="*" cssClass="error"/>
				<c:if test="${error != null}">
					<span class = "error">"${error}"</span>
				</c:if>
					</div>
		
		<div class="form-group">
			<label class="control-label">Назва фільму</label>
			<form:input path="filmName" cssClass="form-control" title="Назва фільму" />
		</div>
		<div style="display: flex; justify-content: flex-start;">
		 	<div>
				<label class="control-label">Категорія</label>
				<form:select path="category" cssClass="form-control">
					<c:forEach items="${filmRequest.categorysList}" var="c">
						<form:option value="${c}">${c.val()}</form:option>
					</c:forEach>
				</form:select>	
			</div>
		 	<div>
		 		<label class="control-label">Країна</label>
				<form:select path="country" cssClass="form-control">
					<c:forEach items="${filmRequest.countriesList}" var="c">
						<form:option value="${c}">${c.val()}</form:option>
					</c:forEach>
				</form:select>	
			</div>
			<div>
				<label class="control-label">Рік виходу</label>
				<form:select path="year" cssClass="form-control">
					<form:option value="0">0000р</form:option>
					<c:forEach begin = "1900" end = "2050" var="c">
						<form:option value="${c}">${c}р</form:option>
					</c:forEach>
				</form:select>	
			</div>
			<div>
				<label class="control-label">Тривалість</label>
				<form:select path="movieLength" cssClass="form-control">
					<c:forEach begin = "1" end = "300" var="c">
						<form:option value="${c}">${c} хв</form:option>
					</c:forEach>
				</form:select>	
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label">Опис фільму</label>
			<form:textarea path="filmDescription" cssClass="form-control" title="Опис фільму" rows="7"/>
		</div>
		
		<div class="form-group" style="text-align: center;">
			<br><br>
			<span class="input-group-btn">
				<input type="submit" class="btn btn-primary" value="Зберегти">
			</span>
		</div>
	</form:form>
</div>