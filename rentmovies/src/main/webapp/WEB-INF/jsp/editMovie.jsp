<%@ include file="header.jsp"%>
<br />
<br />

<span class="glyphicon glyphicon-home"></span>
<a href="<c:url value='/movies'/>"> Back to List of Movies</a>

<form:form method="post" modelAttribute="movie" class="form-horizontal"
	enctype="multipart/form-data">
	<script type="text/javascript">
		$(function() {
			$("#dateAddedPicker").datepicker({
				format : 'dd-mm-yyyy',
				autoclose : true,
				todayHighlight : true
			});

			$('#releaseDatePicker').datepicker({
				format : 'dd-mm-yyyy',
				autoclose : true,
				todayHighlight : true
			});
		});
	</script>
	<h2>Edit Movie</h2>
	<div class="form-group">
		<div class="col-md-7">
			<label>Name</label>
			<form:input type="text" path="name" class="form-control"
				required="required" placeholder="Name" />
			<form:errors path="name" cssStyle="help-inline" />
		</div>
	</div>

	<div class="form-group">

		<div class="col-md-7">
			<label>Date Released</label>

			<div class="input-group date" id="releaseDatePicker">
				<form:input type="text" path="releaseDate" id="releaseDate"
					class="form-control" placeholder="Release Date" required="required" />
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-th"></i></span>
			</div>
			<form:errors path="dateAdded" cssStyle="help-inline" />


		</div>
	</div>

	<div class="form-group">

		<div class="col-md-7">
			<label>Date Added</label>
			<div class="input-group date" id="dateAddedPicker">
				<form:input type="text" path="dateAdded" class="form-control"
					placeholder="Date Added" required="required" />
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-th"></i></span>
			</div>
			<form:errors path="dateAdded" cssStyle="help-inline" />
		</div>
	</div>

	<div class="form-group">


		<div class="col-md-7">
			<label>Upload image</label> <input type="file" name="file" /><br />
			<form:errors path="imagePath" cssStyle="help-inline" />
		</div>

	</div>
	<div class="form-group">
		<div class="col-md-7">
			<label>Number Available</label>
			<form:input type="text" path="numberAvailable" class="form-control"
				placeholder="Number Available" required="required" />
			<form:errors path="numberAvailable" cssStyle="help-inline" />

		</div>
	</div>

	<div class="form-group">
		<div class="col-md-7">
			<label>Number in Stock</label>
			<form:input type="number" path="numberInStock" class="form-control"
				placeholder="Number in Stock" required="required" />
			<form:errors path="numberInStock" cssStyle="help-inline" />

		</div>
	</div>

	<div class="form-group">
		<div class="col-md-7">
			<label></label>
			<form:select path="genreId" required="true" class="form-control">
				<form:option value="">Select Genre</form:option>
				<form:options items="${genres}" itemLabel="name" itemValue="id" />
			</form:select>
			<%-- <form:errors path="genreId" cssStyle="help-inline" /> --%>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-7">
			<label></label> <input class="btn btn-success " type="submit"
				value="Edit">
		</div>
	</div>
</form:form>

<%@ include file="footer.jsp"%>