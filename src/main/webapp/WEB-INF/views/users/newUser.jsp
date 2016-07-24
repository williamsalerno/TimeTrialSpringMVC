<div id="wrapper">
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<div id="errors">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category }-${error.message }</li>
			</c:forEach>
		</ul>
	</div>
	<div class="containerLogin">
		<div class="content">
			<div class="login">
				<c:url var="login_url" value="/newUser/form" />
				<form:form class="escondido form-horizontal" role="form"
					id="usersForm" action="${login_url }" method="post"
					commandName="user">
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }" />
					<br>
					<h2 id="h2Form" style="text-align: center; color: #FFC277">
						<fmt:message key="h2.completeRegister" />
						<br> <small style="font-size: 15px"></small>
					</h2>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
						<form:input type="text" class="form-control" path="firstName"
							placeholder="Primeiro nome" aria-describedby="basic-addon1"
							required="required" />
						<strong><form:errors path="firstName"
								cssClass="message-error" /></strong>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
						<form:input type="text" class="form-control" path="lastName"
							placeholder="�ltimo nome" aria-describedby="basic-addon1"
							required="required" />
						<strong><form:errors path="lastName"
								cssClass="message-error" /></strong>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span>
						<form:input type="email" class="form-control" path="email"
							placeholder="email v�lido" required="required" />
						<strong><form:errors path="email"
								cssClass="message-error" /> </strong>
					</div>
					<br>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-globe" aria-hidden="true"></span></span>
						<form:input type="text" class="form-control"
							path="address.country" value="${param.country}" readonly="true" />
						<strong><form:errors path="address.country"
								cssClass="message-error" /> </strong>
					</div>
					<br>
					<c:set var="selectedCountry" value="${param.country}" />
					<c:if
						test="${address.country eq selectedCountry or selectedCountry eq BRAZIL}">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><span
								class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
							<form:input type="text" class="form-control" path="address.cep"
								placeholder="CEP" required="required" />
							<strong><form:errors path="address.cep"
									cssClass="message-error" /> </strong>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><span
								class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
							<form:input type="text" class="form-control" path="address.city"
								placeholder="Cidade" required="required" />
							<strong><form:errors path="address.city"
									cssClass="message-error" /> </strong>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><span
								class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
							<form:input type="text" class="form-control" path="address.state"
								placeholder="Estado" required="required" />
							<strong><form:errors path="address.state"
									cssClass="message-error" /> </strong>
						</div>
						<br>
						<br>
					</c:if>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span>
						<form:input type="text" class="form-control" path="login"
							placeholder="Nome de usu�rio" required="required" />
						<strong><form:errors path="login"
								cssClass="message-error" /> </strong>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span>
						<form:input type="password" class="form-control" path="password"
							placeholder="Senha (entre 6 e 10 d�gitos alfanum�ricos)"
							required="required" />
						<strong><form:errors path="password"
								cssClass="message-error" /> </strong>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span><input
							type="password" class="form-control" id="confirm"
							equalTo="#password" placeholder="Confirme a senha"
							required="required">
					</div>
					<hr style="margin: 40px;">
					<div class="btnForm">
						<button type="submit" class="btn btn-default">Confirmar</button>
					</div>
					<br>
					<div class="clearfix"></div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</div>
<%@ include file="/WEB-INF/jspf/end.jspf"%>