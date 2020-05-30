<jsp:include page="include/header.jsp"></jsp:include>
<div class="container mtb">
    <div class="row centered">
<form action="${pageContext.request.contextPath}/operation" method="post">
<table  >
<tr >
<td align="left">
Name:
</td><td align="left"><input type="text" name="unmae" value="${param.userName}"/></td>
</tr>
<tr>
<td align="left">
Email Address:</td><td align="left"><input type="email" name="email" value="${param.emailid}"/></td>
</tr>
<tr>
<td><input type="hidden" name="form" value="updateuser"></td>
</tr>
<tr>
<td><input type="hidden" name="userId" value="${param.userId}"></td>
</tr>
<tr><td align="left">
<input type="submit"  name="save"/></td></tr>

</table>
</form>

</div></div>

<jsp:include page="include/footer.jsp"></jsp:include>