<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>��Ա����</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>



	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--ҳ�����  -->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />��Ա����
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!--��ͷ  -->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="100">����</td>
					<td width="100">����</td>
					<td width="100">����ֵ</td>
					<td width="100">����</td>
					<td width="100">����</td>
					<td width="100">�μӵı���</td>
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
						<td>${age}</td>
						<td>${power}</td>
						<td>${country.name}</td>
						<td>${coach.name}</td>
						<td><s:iterator value="matches">
								${name}&nbsp; 
							</s:iterator></td>
						<td><s:a action="playerAction_delete?id=%{id}"
								onclick="return delConfirm()">ɾ��</s:a> <s:a
								action="playerAction_editUI?id=%{id}">�޸�</s:a></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!--�������ܳ�����  -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="playerAction_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
			</div>
		</div>

		<!-- ��������  -->
		<s:form action="playerAction_list">
			<s:select name="powerValue" 
			list="#{1:'����ֵ�ɸߵ�������', 2:'����ֵ�ɵ͵�������',3:'��ѡ������ֵ������ʽ' }">
			</s:select>   
			<s:select name="countryNo" headerKey="-1" headerValue="���չ�����ʾ" 
			list="#countryList" listKey="id" listValue="name">
			</s:select>
		</s:form>

		<%@include file="/WEB-INF/jsp/public/pageView.jspf"%>
</body>
</html>





































