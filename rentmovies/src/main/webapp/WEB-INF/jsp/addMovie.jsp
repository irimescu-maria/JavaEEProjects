<%@ include file="header.jsp"%>
<br />
<br />


<span class="glyphicon glyphicon-home"></span><a  href="<c:url value='/movies'/>"> Back to List of Movies</a>

<div class="addMovie-form">


	<form:form method="post" modelAttribute="movie"
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
		<h1>Add Movie</h1>

		<div class="form-group">
			<div class="row">
				<form:input type="text" path="name" class="form-control"
					required="required" />
				<form:errors path="name" cssStyle="help-inline" />
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="input-group date" id="dateAddedPicker">
					<form:input type="text" path="dateAdded" class="form-control"
						placeholder="Date" required="required" />
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-th"></i></span>
				</div>
				<form:errors path="dateAdded" cssStyle="help-inline" />
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<label class="control-label col-md-3" for="imagePath">Image
					path</label>
				<div class="col-md-7">
					<%-- 		<form:input type="file" name="file" path="file" class="form-control input-sm" /> --%>
					<input type="file" name="file" /><br />
					<form:errors path="imagePath" cssStyle="help-inline" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row">

				<div class="col-md-7">
					<div class="input-group date" id="releaseDatePicker">
						<form:input type="text" path="releaseDate" id="releaseDate"
							class="form-control" placeholder="Release Date"
							required="required" />
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-th"></i></span>
					</div>
					<form:errors path="dateAdded" cssStyle="help-inline" />

				</div>

			</div>
		</div>

		<div class="form-group">
			<div class="row">

				<form:input type="text" path="numberAvailable" class="form-control"
					placeholder="Number Available" required="required" />
				<form:errors path="numberAvailable" cssStyle="help-inline" />

			</div>
		</div>

		<div class="form-group">
			<div class="row">

				<form:input type="text" path="numberInStock" class="form-control"
					placeholder="Number in Stock" required="required" />
				<form:errors path="numberInStock" cssStyle="help-inline" />

			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<form:select path="genreId" required="true" class="form-control">
					<form:option value="">Select Genre</form:option>
					<form:options items="${genres}" itemLabel="name" itemValue="id" />
				</form:select>
				<%-- <form:errors path="genreId" cssStyle="help-inline" /> --%>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<input class="btn btn-success btn-lg btn-block" type="submit"
					value="Add">
			</div>
		</div>
	</form:form>
</div>
<%@ include file="footer.jsp"%>