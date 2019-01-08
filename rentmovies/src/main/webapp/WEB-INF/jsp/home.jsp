<%@ include file="header.jsp"%>
<br />
<br />
<br />

<c:forEach items="${movies}" var="movie">

	<div class="row">
		<div class="shadow">
			<div class="column">
				<h1>${movie.name}</h1>
				<p>Movie in stock: ${movie.numberInStock}</p>
				<p><img src="${pageContext.request.contextPath}/image/${movie.imagePath}" alt = "${movie.imagePath}" width="100px" height="70px"/></p>
				<p>${movie.genre.name}</p>
				<a href="<c:url value='rent'/>" class="btn btn-info">Rent Movie</a>
			</div>
		</div>
	</div>
</c:forEach>
<%@ include file="footer.jsp"%>