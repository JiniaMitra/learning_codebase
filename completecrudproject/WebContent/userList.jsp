<%@page import="java.util.List" %>
<%@page import="com.easylearning.entity.User" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container mtb">
    <div class="row centered">
<table border="2">
<%!
String temp;
String tempDelete;
%>
<%
List<User> listUser=(List)request.getAttribute("userList");

 for(int i=0;i<listUser.size();i++)
{
	temp=request.getContextPath()+"/operation?page=updateUser&userId="+listUser.get(i).getUser_id()
			+"&userName="+	listUser.get(i).getUsername()
			+"&emailid="+listUser.get(i).getEmailid();
			
			tempDelete=	request.getContextPath()+"/operation?page=deleteUser&userId="+listUser.get(i).getUser_id();
	out.println("<tr>");
	
	out.println("<td>"+
	listUser.get(i).getUser_id()
	+"</td>");
	out.println("<td>"+
			listUser.get(i).getUsername()
			+"</td>");
	out.println("<td>"+
			listUser.get(i).getEmailid()
			+"</td>");
	

	out.println("<td>"+"<a href="+temp+">Update</a>|");
%>
	<a href="<%=tempDelete%>" onclick="if(!confirm('are you sure you want to delete?')) return false" >Delete</a>
	</td>
	</tr>
	<%
	
}
	 %>
	



</table>

</div></div>
<jsp:include page="include/footer.jsp"></jsp:include>