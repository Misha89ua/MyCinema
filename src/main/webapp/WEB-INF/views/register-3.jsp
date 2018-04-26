<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<form:form action="/register-3" modelAttribute="userModel" method="POST">
					<legend style="text-align: center;">Завершення реєстрації</legend>
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
							
							<c:if test="${error != null}">
								<span class = "error">"${error}"</span>
							</c:if>
							
						</div>
						<div class="form-group">
							<label class="control-label">Ім'я</label>
							<form:input path="firstName" cssClass="form-control" title="Ім'я" />
							
							<label class="control-label">Прізвище (не обовязково)</label>
							<form:input path="lastName" cssClass="form-control" title="Прізвище" />
											
							<label class="control-label">Пароль</label>
							<form:password path="password" cssClass="form-control" title="Пароль" />
							
							<label class="control-label">Підтвердження паролю</label>
							<form:password path="passwordConfirmation" cssClass="form-control" title="Підтвердження паролю" />
							
							<div style="display: none;">
							<form:input path="email" cssClass="form-control" title="e-mail" />
							</div>
						
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Зареєструватися">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>