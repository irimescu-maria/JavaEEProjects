<%@ include file="header.jsp"%>
<br />
<br />
<br />
<c:choose>
	<c:when test="${empty user.email}">
		<li><a href="<c:url value = "/signup"/>">Register</a></li>
		<li><a href="<c:url value="/login" />">Login</a></li>
	</c:when>
	<c:otherwise>
		<li>Hello ${user.email}</li>
		<li><a href="<c:url value="/logout" />">Log out</a></li>

	</c:otherwise>
</c:choose>
<c:forEach items="${movies}" var="movie">

	<div class="row">
		<div class="shadow">
			<div class="column">
				<h1>${movie.name}</h1>
				<p>${movie.numberInStock}</p>
				<p>${movie.imagePath}</p>
				<p>${movie.genre.name}</p>
				<a href="<c:url value='rent'/>" class="btn btn-info">Rent Movie</a>
			</div>
		</div>
	</div>
</c:forEach>
<%@ include file="footer.jsp"%>