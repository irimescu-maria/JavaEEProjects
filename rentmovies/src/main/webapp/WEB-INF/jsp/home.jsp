<%@ include file="header.jsp" %>
<br />
<br />
<br />
	<div class="contaioner">
	<%  String userName = request.getParameter("firstname"); %>
		<h2>Hi ${userName}, this is the home page.</h2>

	</div>
<%@ include file="footer.jsp" %>