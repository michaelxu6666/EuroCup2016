<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>添加国家</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>

	<!--标题显示  -->
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				国家信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容  -->
	<div id="MainArea">
		<s:form action="countryAction_add">

			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
					国家信息
				</div>
			</div>

			<!--表单内容显示  -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td>国名</td>
							<td><s:textfield name="name" cssClass="InputStyle required"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>能力值</td>
							<td><s:textfield name="power" cssClass="InputStyle"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>教练</td>
							<td><s:select name="coachId" list="#coachList" listKey="id"
									listValue="name" headerKey="" headerValue="请选择教练">
								</s:select>
							</td>
						</tr>
						<tr>
							<td width="100">球员</td>
							<td><s:select name="playerIds" cssClass="SelectStyle"
									multiple="true" size="23" list="#playerList" listKey="id"
									listValue="name">
								</s:select> 按住Ctrl键可以多选或取消选择</td>
						</tr>

						<tr>
							<td width="100">比赛</td>
							<td><s:select name="matchIds" cssClass="SelectStyle"
									multiple="true" size="30" list="#matchList" listKey="id"
									listValue="name">
								</s:select> 按住Ctrl键可以多选或取消选择</td>
						</tr>


					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" />
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" />
				</a>
			</div>

		</s:form>


	</div>

</body>
</html>






























































