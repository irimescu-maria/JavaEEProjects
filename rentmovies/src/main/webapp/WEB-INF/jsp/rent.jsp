<%@ include file="header.jsp"%>
<br />
<br />
<br />
<br />

<h2>Rent form</h2>
<form:form method="post" modelAttribute="rent">
	
	<div class="row">
		<label class="control-label col-md-3" for="dateRented">Date
			Rented</label>
		<div class="col-md-7">
			<div class="input-group date" id="dateRented">
				<form:input type="text" path="dateRented" id="dateRented"
					class="form-control input-sm" />
			</div>
			<form:errors path="dateRented" cssStyle="help-inline" />
		</div>
	</div>

	<div class="row">
		<label class="control-label col-md-3" for="dateRented">Date
			Returned </label>
		<div class="col-md-7">
			<div class="input-group date" id="dateReturned">
				<form:input type="text" path="dateReturned" id="dateReturned"
					class="form-control input-sm" />
			</div>
			<form:errors path="dateReturned" cssStyle="help-inline" />
		</div>
	</div>
	
	<div class="row">
			<div class="form-actions">
				<input class="btn btn-default pull-center" type="submit" value="Rent">
			</div>
		</div>
</form:form>

<%@ include file="footer.jsp"%>