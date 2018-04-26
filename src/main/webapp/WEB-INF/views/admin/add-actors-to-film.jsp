<%@include file = "/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<c:if test="!${filmRequest.addedPersonList.isEmpty}">
	<c:forEach items="film.addedPersonList" var="a">
		${a.firstName} ${a.lastName}
		<a href="${pageContext.request.contextPath}/admin/edit-user/${user.id}">
			<button type="button" class="btn btn-success btn-xs" style="margin: 5px" title="Добавити"><span class="glyphicon glyphicon-edit"></span></button>
		</a>
	</c:forEach>
</c:if>

<form:form modelAttribute="filmRequest" method="POST" action="/admin/film-add" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label">Назва фільму</label>
		<form:input path="filmName" cssClass="form-control" title="Назва фільму" />
	</div>
</form:form>

<a href="${pageContext.request.contextPath}/admin/film-add">
			<button type="button" class="btn btn-success btn-xs" style="margin: 5px" title="Добавити"><span class="glyphicon glyphicon-edit"></span></button>
		</a>