<%@ include file="header.jsp"%>
<br/>
<br/>
<br/>
<br/>

<h2>Rent form</h2>
<form:form method="post" modelAttribute="rent">
	<div class="row">
		<label class="control-label col-md-3" for="user">User</label>
		<div class="col-md-7">
			<form:input type="text" path="user"
				class="form-control input-sm" />
			<form:errors path="user" cssStyle="help-inline" />
		</div>
		
		<label class="control-label col-md-3" for="movie">Movie</label>
		<div class="col-md-7">
			<form:input type="text" path="user"
				class="form-control input-sm" />
			<form:errors path="user" cssStyle="help-inline" />
		</div>
	</div>
	
</form:form>

<%@ include file= "footer.jsp" %>