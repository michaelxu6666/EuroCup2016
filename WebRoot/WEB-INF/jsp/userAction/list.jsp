<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>�û��б�</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>



	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--ҳ�����  -->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />�û��б�
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!--��ͷ  -->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="100">��ʵ����</td>
					<td width="100">��¼��</td>
					<td width="100">�Ա�</td>
					<td>��ز���</td>
					<td>��ע</td>
				</tr>
			</thead>

			<!--��ʾ�����б�  -->
			<!-- ????? �����е�datakey   -->
			<tbody id="TableData" class="dataContainer" datakey="">

				<s:iterator value="recordList">
					<tr class="TableDetail1 template">
						<td>${name}</td>
						<td>${loginName}</td>
						<td>${gender}</td>
						<td><s:a action="userAction_delete?id=%{id}" onclick="return delConfirm()">ɾ��</s:a> 
							<s:a action="userAction_editUI?id=%{id}">�޸�</s:a>
							<s:a action="userAction_setPrivilegeUI?id=%{id}">����Ȩ��</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!--�������ܳ�����  -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="userAction_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
			</div>
		</div>

		<%@include file="/WEB-INF/jsp/public/pageView.jspf"%>
		<s:form action="userAction_list"></s:form>
</body>
</html>





































