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
				<input type="button" value="Submit" data-movie-id="${movie.id}" class="btn btn-info">
				<a href="<c:url value='rent?id=${movie.id}'/>" class="btn btn-info">Rent Movie</a>
			</div>
		</div>
	</div>
</c:forEach>
<script  type="text/javascript">
	$('input').on('click', function(e) {
		e.preventDefault();
		var myId = $(this).attr("data-movie-id");
	// var itemID = $('input').val();
		$.ajax({
			type: 'POST',
			url: 'rent?id='+ myId,
			success: function(data){
				console.log('success', data);
			},
			error: function(exception){
				alert('Exception:' + exception);
			}
		});
		/* e.preventDefault(); */
	});
</script>
<%@ include file="footer.jsp"%>