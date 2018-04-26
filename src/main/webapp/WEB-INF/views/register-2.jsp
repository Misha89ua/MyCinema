<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<form:form action="/register-2" modelAttribute="userModel" method="POST">
					<legend style="text-align: center;">Реєстрація крок 2</legend>
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						
  							<label class="control-label">На ваш e-mail: ${userModel.email} відправлено код, введіть його сюди</label>
							<form:input path="tokenConfirmation" cssClass="form-control" title="Код" />
							
							<label class="control-label">код</label>
							<form:input path="token" cssClass="form-control" title="Код" />
							
							<div style = "display:none">
							<label class="control-label"></label>
							<form:input path="email" cssClass="form-control" title="E-mail"  />
							</div>
											
						</div>
						<div class="form-group" style="text-align: center;">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Продовжити">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>