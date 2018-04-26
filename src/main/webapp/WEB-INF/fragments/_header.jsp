<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">My cinema</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/test-page">Сеанси<span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/user/films">Фільми</a></li>
        <li><a href="${pageContext.request.contextPath}/user/halls">Зали</a></li>
        <li><a href="${pageContext.request.contextPath}/test-page">Актори</a></li>
        <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole ('ROLE_ADMIN')">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Адмінка <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${pageContext.request.contextPath}/admin/users">Користувачі</a></li>
	            <li class="divider"></li>
	            <li><a href="${pageContext.request.contextPath}/admin/films">Фільми</a></li>
	            <li><a href="${pageContext.request.contextPath}/admin/film-add">Додати фільм</a></li>
	            <li class="divider"></li>
	            <li><a href="${pageContext.request.contextPath}/user/halls">Зали</a></li>
	            <li><a href="${pageContext.request.contextPath}/admin/hall-add">Додати зал</a></li>
	          </ul>
	        </li>
	    </sec:authorize>
	    </sec:authorize>
      </ul>

      <ul class="nav navbar-nav navbar-right" style="width: 300px;">
			<sec:authorize access="!isAuthenticated()">
		            <li><a href="/login">Вхід</a></li>
		            <li class="divider"></li>
		            <li><a href="/register-1">Реєстрація</a></li>		
		     </sec:authorize>
		     
		     <sec:authorize access="isAuthenticated()">
		     		<sec:authentication property="principal.username" var="username"/>
	     			<li><a href="/user">${username}</a></li>

					<c:url var="logoutUrl" value="/logout" />
					<form:form action="${logoutUrl}" method="post" cssStyle="padding-top: 7px;">
						<li><input class="btn btn-danger" type="submit" value="Вихід" /></li>
					</form:form>
			</sec:authorize>
      </ul>
    </div>
  </div>
</nav>
