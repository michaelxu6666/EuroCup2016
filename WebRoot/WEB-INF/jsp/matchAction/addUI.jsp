<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>添加比赛</title>
		<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	</head>
	<body>
		
		<!--标题显示  -->
		<!-- 标题显示 -->
	<div id="Title_bar">
		 <div id="Title_bar_Head">
		      <div id="Title_Head"></div>
		       <div id="Title"><!--页面标题-->
		           <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 比赛信息
		        </div>
		        <div id="Title_End"></div>
		   </div>
	</div>
	
	<!--显示表单内容  -->
		<div id="MainArea">
			<s:form action="matchAction_add">
				
				<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 比赛信息 </div> 
        		</div>	
				
				<!--表单内容显示  -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td>名称</td>
								<td>
									<s:textfield name="name" cssClass="InputStyle required"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>比赛时间</td>
								<td>
									<s:textfield name="matchTime" cssClass="InputStyle"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>比赛地点</td>
								<td>
									<s:textfield name="matchPosition" cssClass="InputStyle"></s:textfield>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				  <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
				
			</s:form>
		
		
		</div>
		
	</body>
</html>  






























































