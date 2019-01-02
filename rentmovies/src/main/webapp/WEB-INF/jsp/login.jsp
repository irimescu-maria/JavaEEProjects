
<%@ include file="header.jsp"%>
<br />
<br />
<br />
<form:form method="post" modelAttribute="user">
	<h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
	
	<div class="form-group">
		<label for="email" class="sr-only">Email</label>
		
			<form:input path="email" type="email" name="email" id="email"
				class="form-control" placeholder="user@yahoo.com"
				required="autofocus" />
		
	</div>

	<div class="form-group">
		<label for="inputPassword" class="sr-only">Password</label>

			<form:input path="password" type="password" class="form-control"
				placeholder="Password" required="autofocus" id="inputPassword"/>

	</div>
	
	<div class="checkbox mb-2">
		<label> <input type="checkbox" name="remember-me" /> Remember
			me
		</label>
	</div>
	<div colspan="2" align="center">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</div>
	<div class="margin-top20 text-center">
		Don't have an account? <a href="<c:url value = "/signup"/>">Create
			an account</a>
	</div>
</form:form>

<%@ include file="footer.jsp"%>