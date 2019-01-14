<%@ include file="header.jsp"%>
<br />
<br />
<br />
<br />
<br />

<c:if test="${not empty message}">
<div class="alert alert-success">${message}</div>
</c:if>
<div class="movie">
	<c:forEach items="${movies}" var="movie">
		<div class="movies">
			<ul>
				<li><h4>${movie.name}</h4></li>

				<li><img
					src="${pageContext.request.contextPath}/image/${movie.imagePath}"
					alt="${movie.imagePath}" width="100px" height="70px" class="center" /></li>
				<br />
				<c:choose>
					<c:when test="${movie.numberInStock== 0}">
						<li><p>
								<span class="disp">Movie in stock</span><br /> Does not
								available
							</p></li>
					</c:when>
					<c:otherwise>
						<li><p>
								<span class="disp">Movie in stock</span><br />
								${movie.numberInStock} available
							</p></li>
					</c:otherwise>
				</c:choose>

				<li>Genre: ${movie.genre.name}</li>
				<li><input type="button" value="Rent movie"
					data-movie-id="${movie.id}" class="btn btn-info btn-md btn-block"></li>
			</ul>
		</div>
	</c:forEach>
</div>
<script type="text/javascript">
	$('input').on('click', function(e) {
		e.preventDefault();
		var myId = $(this).attr("data-movie-id");

		$.ajax({
			type : 'POST',
			url : 'rent?id=' + myId,
			success : function(data) {
				console.log('success', data);
			
				   window.setTimeout(function(){window.location.reload()}, 1000);
					$('.alert').show();
					
			},
			error : function(exception) {
				alert('Exception:' + exception);
			}
		});
	});
</script>
<%@ include file="footer.jsp"%>