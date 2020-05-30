<jsp:include page="include/header.jsp"></jsp:include>
<div class="container mtb">
    <div class="row centered">
<form action="${pageContext.request.contextPath}/operation" method="post">
<table  >
<tr >
<td align="left">
Name:
</td><td align="left"><input type="text" name="unmae" /></td>
</tr>
<tr>
<td align="left">
Email Address:</td><td align="left"><input type="email" name="email" /></td>
</tr>
<tr>
<td><input type="hidden" name="form" value="adduser"></td>
</tr>
<tr><td align="left">
<input type="submit"  name="save"/></td></tr>

</table>
</form>

</div></div>

<jsp:include page="include/footer.jsp"></jsp:include>