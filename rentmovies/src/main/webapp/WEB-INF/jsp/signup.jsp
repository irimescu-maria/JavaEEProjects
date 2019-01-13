<%@ include file="header.jsp"%>
<br />
<br />
<br />

<div class="signup-form">
	<form:form method="post" modelAttribute="user">
		<div class="form-group">
			<div class="row">
				<div class="col-sm-8">
					<h2>Register User</h2>
					<hr>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-xs-6">
					<form:input type="text" path="firstname" class="form-control"
						placeholder="First Name" required="required" />
						<form:errors path="email" cssStyle="help-inline" />
				</div>
				<div class="col-xs-6">
					<form:input type="text" path="lastname" class="form-control"
						placeholder="Last Name" required="required" />
<form:errors path="email" cssStyle="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<form:input type="text" path="email" class="form-control"
					required="required" placeholder="Email" />
				<form:errors path="email" cssStyle="help-inline" />

			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<form:select path="roleId" required="true"
					class="form-control input-sm">
					<form:option value="">Select Role</form:option>
					<form:options items="${roles}" itemLabel="name" itemValue="id" />
				</form:select>
				<%-- <form:errors path="genreId" cssStyle="help-inline" /> --%>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="form-group">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password" />
					<form:errors path="email" cssStyle="help-inline" />
				</div>
			</div>
		</div>

		<div class="from-group">
			<div class="row">
				<input class="btn btn-success btn-lg btn-block" type="submit"
					value="Register">
			</div>
		</div>
	</form:form>
</div>
<%@ include file="footer.jsp"%>