<%@ include file="header.jsp"%>
<br />
<br />
<br />

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
		<label class="control-label col-md-3" for="firstname">First
			name</label>
		<div class="col-md-7">
			<form:input type="text" path="firstname"
				class="form-control input-sm" />
			<form:errors path="firstname" cssStyle="help-inline" />
		</div>
	</div>

	<div class="row">
		<label class="control-label col-md-3" for="lastname">Last name</label>
		<div class="col-md-7">
			<form:input type="text" path="lastname" class="form-control input-sm" />
			<form:errors path="lastname" cssStyle="help-inline" />
		</div>

	</div>

	<div class="row">
		<label class="control-label col-md-3" for="email">Email</label>
		<div class="col-md-7">
			<form:input type="text" path="email" class="form-control input-sm" />
			<form:errors path="email" cssStyle="help-inline" />
		</div>
	</div>
	
	<div class="row">
		<label class="control-label col-md-3" for="role">Role</label>
		<div class="col-md-7">
			<form:select path="roleId" required="true"
				class="form-control input-sm">
				<form:option value="">Select</form:option>
				<form:options items="${roles}" itemLabel="role" itemValue="id" />
			</form:select>
			<%-- <form:errors path="genreId" cssStyle="help-inline" /> --%>
		</div>
	</div>
	<div class="row">
		<label class="control-label col-md-3" for="password">Password</label>
		<div class="col-md-7">
			<form:input type="password" path="password" class="form-control input-sm" />
			<form:errors path="email" cssStyle="help-inline" />
		</div>
		
	</div>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="form-actions">
				<input class="btn btn-default pull-center" type="submit" value="Add">
			</div>
		</div>
	</div>
</form:form>

<%@ include file="footer.jsp"%>