<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>�û���½ҳ��</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
<%-- <script type="text/javascript">
$(function() {
	document.forms[0].loginName.focus();
});

</script> --%>

<script type="text/javascript">
		$(function(){
			document.forms[0].loginName.focus();
		});
</script>

</head>
<body>
	<s:form action="userAction_login">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td>��¼��</td>
					<td>
						<s:textfield name="loginName"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<s:password name="password"></s:password>
					</td>
				</tr>
			<s:submit></s:submit>
			
			</tbody>
		</table>
	</s:form>
</body>

</html>





















