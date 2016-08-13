<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>国家列表</title>
		<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	</head>
	<body>
		
		<div id="Title_bar">
		    <div id="Title_bar_Head"> 
			<div id="Title_Head"></div> 
			<div id="Title"> <!--页面标题  -->
				<img border="0" width="13" height="13" src=
				"${pageContext.request.contextPath}/style/images/title_arrow.gif" />国家列表
			</div>
			<div id="Title_End"></div>
		   </div> 
		</div>  
		
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">
				
				<!--表头  -->
				<thead>
					<tr align=center valign=middle id=TableTitle>
						<td width="100">国名</td>
						<td width="100">能力值</td>
						<td width="100">教练</td>
						<td width="100">球员</td>
						<td width="100">比赛清单</td>
						<td>相关操作</td>
						<td>备注</td>
					</tr>
				</thead>
				
				<!--显示数据列表  -->
<!-- ????? 改行中的datakey   -->				
				<tbody id="TableData" class="dataContainer" datakey="">
				
				<s:iterator value="recordList">
					<tr class="TableDetail1 template">
						<td>${name}</td>
						<td>${power}</td>
						<td>${coach.name}</td>
						<td>
							<s:iterator value="players">
								${name}&nbsp;
							</s:iterator>
						</td>
						<td>
							<s:iterator value="matches">
								${name}&nbsp; 
							</s:iterator>
						</td>
						<td>
							<s:a action="countryAction_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
							<s:a action="countryAction_editUI?id=%{id}">修改</s:a>
						</td>
						
					</tr>
				</s:iterator>
				</tbody>
			</table>
			
			<!--其他功能超链接  -->
			<div id="TableTail">
				<div id="TableTail_inside">
					<s:a action="countryAction_addUI"> 
						<img src="${pageContext.request.contextPath}/style/images/createNew.png" />
					</s:a>
				</div>
			</div>
		</div>
		
<%@include file="/WEB-INF/jsp/public/pageView.jspf" %>
<s:form action="countryAction_list">
	<s:select name="powerValue" headerKey="-1" headerValue="默认排序" list="#{1:'按照国家队能力值排序'}"></s:select>
	
</s:form>
		
	</body>
</html>  





































