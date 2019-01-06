<%@ include file="header.jsp"%>
<br/>
<br/>
<br/>
<br/>

<h1>List of Movies</h1>
<c:if test="${not empty messge}">
	<div class="alert alert-success">${message}</div>
</c:if>
<div><a href= "<c:url value='movies/add'/>" class="btn btn-info">Add new movie</a></div>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date Added</th>
			<th>Release Date</th>
			<th>Number in Stock</th>
			<th>Number Available</th>
			<th>Image path</th>
			<th>Genre</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.name}</td>
				<td>${movie.dateAdded}</td>
				<td>${movie.releaseDate}</td>
				<td>${movie.numberInStock}</td>
				<td>${movie.numberAvailable}</td>
				<td><img src="/${movie.imagePath}" alt = "${movie.imagePath}"/></td>
				<td>${movie.genre.name}</td>
				<td><a href="<c:url value='movie/edit?id=${movie.id}'/>" class="btn btn-primary">Edit</a> |
					<a href="<c:url value='movie/delete?id=${movie.id}'/>" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file= "footer.jsp" %>