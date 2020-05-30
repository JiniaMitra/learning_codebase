<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List" %>
<%@page import="com.easylearning.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container mtb">
    <div class="row centered">
<table border="2">

<c:forEach var="user" items="${userList}">
<tr>
<c:url var="updateUrl" value="operation">
<c:param name="page" value="updateUser"></c:param>
<c:param name="userId" value="${user.user_id}"></c:param>
<c:param name="userName" value="${user.username}"></c:param>
<c:param name="emailid" value="${user.emailid}"></c:param>
</c:url>
<c:url var="deleteUrl" value="operation">
<c:param name="page" value="deleteUser"></c:param>
<c:param name="userId" value="${user.user_id}"></c:param>
</c:url>


<td>
${user.user_id}
</td>
<td>
${user.username}
</td>
<td>
${user.emailid}
</td>
<td>
<a href="${updateUrl}">update</a>
</td>
<td>
<a href="${deleteUrl}">delete</a>
</td>
</tr>
</c:forEach>

</table>

</div></div>
<jsp:include page="include/footer.jsp"></jsp:include>