<%@ include file="header.jsp"%>
<br />
<br />
<br />
<br />
<h1>Add Movie</h1>
<form:form method="post" modelAttribute="movie" class="form-horizontal">
	<div role="form">
		<div class="row">
			<label class="control-label col-md-3" for="name">Name</label>
			<div class="col-md-7">
				<form:input type="text" path="name" class="form-control input-sm" />
				<form:errors path="name" cssStyle="help-inline" />
			</div>
		</div>
		<div class="row">
			<label class="control-label col-md-3" for="dateAdded">Date
				Added</label>
			<div class="col-md-7">
				<div class="input-group date" id="dateAddedPicker">
					<form:input type="text" path="dateAdded" id="dateAdded"
						class="form-control input-sm" />
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-th"></i></span>
				</div>
				<form:errors path="dateAdded" cssStyle="help-inline" />

			</div>
			<script type="text/javascript">
			
				
				$('#dateAddedPicker').datepicker({
					format : 'dd-mm-yyyy',
					autoclose : true,
					todayHighlight : true
				});
			</script>
		</div>

		<div class="row">
			<label class="control-label col-md-3" for="releaseDate">Release
				Date</label>
			<div class="col-md-7">
				<div class="input-group date" id="releaseDatePicker">
					<form:input type="text" path="releaseDate" id="releaseDate"
						class="form-control input-sm" />
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-th"></i></span>
				</div>
				<form:errors path="dateAdded" cssStyle="help-inline" />

			</div>
			<script type="text/javascript">
				$('#releaseDatePicker').datepicker({
					format : 'dd-mm-yyyy',
					autoclose : true,
					todayHighlight : true
				});
			</script>
		</div>

		<div class="row">
			<label class="control-label col-md-3" for="numberAvailable">Number
				Available</label>
			<div class="col-md-7">

				<form:input type="text" path="numberAvailable"
					class="form-control input-sm" />
				<form:errors path="numberAvailable" cssStyle="help-inline" />
			</div>
		</div>
		
		<div class="row">
			<label class="control-label col-md-3" for="numberInStock">Number in Stock</label>
			<div class="col-md-7">

				<form:input type="text" path="numberInStock"
					class="form-control input-sm" />
				<form:errors path="numberInStock" cssStyle="help-inline" />
			</div>
		</div>
		
		<div class="row">
			<label class="control-label col-md-3" for="genre">Genre</label>
			<div class="col-md-7">
				<form:select path="genreId" required="true" class="form-control input-sm">
					<form:option value="">Select</form:option>
					<form:options items="${genres}" itemLabel="name" itemValue="id" />
				</form:select>
					<%-- <form:errors path="genreId" cssStyle="help-inline" /> --%>
			</div>
		</div>
		
		<div class="row">
			<div class="form-actions">
				<input class="btn btn-default pull-center" type="submit" value="Add">
			</div>
		</div>
	</div>
</form:form>

<%@ include file="footer.jsp"%>