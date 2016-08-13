<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>比赛清单</title>
		<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	</head>
	<body>
		
		<div id="Title_bar">
		    <div id="Title_bar_Head"> 
			<div id="Title_Head"></div> 
			<div id="Title"> <!--页面标题  -->
				<img border="0" width="13" height="13" src=
				"${pageContext.request.contextPath}/style/images/title_arrow.gif" />比赛清单
			</div>
			<div id="Title_End"></div>
		   </div> 
		</div>  
		
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">
				
				<!--表头  -->
				<thead>
					<tr align=center valign=middle id=TableTitle>
						<td width="100">名称</td>
						<td width="100">比赛时间</td>
						<td width="100">比赛地点</td>
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
						<td>${matchTime}</td>
						<td>${matchPosition}</td>
						<td>
							<s:a action="matchAction_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
							<s:a action="matchAction_editUI?id=%{id}">修改</s:a>
						</td>
						
					</tr>
				</s:iterator>
				</tbody>
			</table>
			
			<!--其他功能超链接  -->
			<div id="TableTail">
				<div id="TableTail_inside">
					<s:a action="matchAction_addUI"> 
						<img src="${pageContext.request.contextPath}/style/images/createNew.png" />
					</s:a>
				</div>
			</div>
			
<%@include file="/WEB-INF/jsp/public/pageView.jspf" %>			
<s:form action="matchAction_list">
<s:select name="timeOrder" headerKey="-1" headerValue="默认排序" 
	list="#{1:'按照比赛时间升序排序',2:'按照比赛时间降序排序'}"></s:select>
</s:form>
			
			
			
		</div>
		
	</body>
</html> 





































