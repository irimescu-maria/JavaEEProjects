<%@ include file="header.jsp"%>
<br />
<br />
<br />
<div class="container">
	<form:form method="post" modelAttribute="user">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="alert alert-success" role="alert" th:if="${msg}"
					th:utext="${msg}"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2>Register User</h2>
				<hr>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 field-label-responsive">
				<form:label path="firstname">First name</form:label>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<div class="input-group mb-2 mr-sm-2 mb-sm-0">
						<div class="input-group-addon" style="width: 2.6rem">
							<i class="fa fa-user"></i>
						</div>
					</div>
				</div>

				<form:input path="firstname" placeholder="First name" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 field-label-responsive">
				<form:label path="lastname">Last name</form:label>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<div class="input-group mb-2 mr-sm-2 mb-sm-0">
						<div class="input-group-addon" style="width: 2.6rem">
							<i class="fa fa-user"></i>
						</div>
					</div>
				</div>
				<form:input path="lastname" placeholder="Last name" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 field-label-responsive">
				<form:label path="email">Email</form:label>
			</div>
			<div class="col-md-6">
				<div class="input-group-addon" style="width: 2.6rem">
					<i class="fa fa-user"></i>
				</div>
				<form:input path="email" placeholder="username@yahoo.com" required="autofocus" />
			</div>
			<div class="col-md-3">
				<div class="form-control-feedback">
					<%-- 	<span class="text-danger align-middle" th:if="${#fields.hasErrors('email')}" th:errors="*{email}">
						</span> --%>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 field-label-responsive">
				<form:label path="password">Password</form:label>
			</div>
			<div class="col-md-6">
				<div class="input-group-addon" style="width: 2.6rem">
					<i class="fa fa-user"></i>
				</div>
				<form:input path="password" placeholder="Password" required="autofocus" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<button type="submit" class="btn btn-success">
					<i class="fa fa-user-plus"></i> Register
				</button>
			</div>
		</div>
	</form:form>
</div>
</body>
</html>