<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>添加球员</title>
		<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	</head>
	<body>
		
		<!--标题显示  -->
		<!-- 标题显示 -->
	<div id="Title_bar">
		 <div id="Title_bar_Head">
		      <div id="Title_Head"></div>
		       <div id="Title"><!--页面标题-->
		           <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 修改球员信息
		        </div>
		        <div id="Title_End"></div>
		   </div>
	</div>
	
	<!--显示表单内容  -->
		<div id="MainArea">
			<s:form action="playerAction_edit">
				<s:hidden name="id"></s:hidden>
				<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 球员信息 </div> 
        		</div>	
				
				<!--表单内容显示  -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td>姓名</td>
								<td>
									<s:textfield name="name" cssClass="InputStyle"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>年龄</td>
								<td>
									<s:textfield name="age" cssClass="InputStyle"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>国家</td>
								<td>
									<s:select name="countryId" list="#countryList" listKey="id" listValue="name"
										headerKey="" headerValue="请选择所属国家">
									</s:select>
								</td>
							</tr>
							<tr>
								<td>教练</td>
								<td>
									<s:select name="coachId" list="#coachList" listKey="id" listValue="name"
										headerKey="" headerValue="请选择教练">
									</s:select>
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






























































