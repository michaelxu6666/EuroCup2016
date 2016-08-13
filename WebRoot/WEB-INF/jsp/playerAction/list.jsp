<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>球员名单</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>



	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题  -->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />球员名单
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!--表头  -->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="100">姓名</td>
					<td width="100">年龄</td>
					<td width="100">能力值</td>
					<td width="100">国家</td>
					<td width="100">教练</td>
					<td width="100">参加的比赛</td>
					<td>相关操作</td>
					<td>备注</td>
				</tr>
			</thead>

			<!--显示数据列表  -->
			<!-- ????? 该行中的datakey   -->
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
								onclick="return delConfirm()">删除</s:a> <s:a
								action="playerAction_editUI?id=%{id}">修改</s:a></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!--其他功能超链接  -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="playerAction_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
			</div>
		</div>

		<!-- 过滤条件  -->
		<s:form action="playerAction_list">
			<s:select name="powerValue" 
			list="#{1:'能力值由高到低排序', 2:'能力值由低到高排序',3:'请选择能力值的排序方式' }">
			</s:select>   
			<s:select name="countryNo" headerKey="-1" headerValue="按照国家显示" 
			list="#countryList" listKey="id" listValue="name">
			</s:select>
		</s:form>

		<%@include file="/WEB-INF/jsp/public/pageView.jspf"%>
</body>
</html>





































