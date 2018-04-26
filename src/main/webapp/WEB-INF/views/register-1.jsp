<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<form:form action="/register-1" modelAttribute="userModel" method="POST">
					<legend style="text-align: center;">Реєстрація крок 1</legend>
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						
  							<label class="control-label">Введіть свій діючий E-mail</label>
							<form:input path="email" cssClass="form-control" title="E-mail" />
											
						</div>
						<div class="form-group" style="text-align: center;">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Перевірити E-mail">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>