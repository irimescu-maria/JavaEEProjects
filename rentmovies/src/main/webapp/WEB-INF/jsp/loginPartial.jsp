<%

  if (session != null)
  {
	  String userName = request.getParameter("firstname");
  %>
	  <ul class="nav navbar-nav navbar-right">
		<li><a href="<c:url value = "/signup"/>">Register</a></li>
		<li><a href="<c:url value="/login" />">Login</a></li>
	</ul>
  <%} else{%>
	  <ul class="nav navbar-nav navbar-right">
			<li>${userName}</li>
			<li><a href="<c:url value="/logout" />">Sign out</a></li>
 <% }
%>
	
