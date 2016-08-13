<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>用户权限设置</title>
<%@include file="/WEB-INF/jsp/public/common.jspf"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<script language="javascript"
	src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />

<script type="text/javascript">
		$(function(){
			
			// 给所有的权限复选框添加事件
			$("[name=privilegeIds]").click(function(){

				// 自己选中或取消时，把所有的下级权限也都同时选中或取消
				$(this).siblings("ul").find("input").attr("checked", this.checked);
				
				// 当选中一个权限时，也要同时选中所有的直系上级权限
				if(this.checked){
					$(this).parents("li").children("input").attr("checked", true);
				}
				// 当取消一个权限时，同级没有选中的权限了，就也取消他的上级权限，再向上也这样做。
				else{
					if( $(this).parent().siblings("li").children("input:checked").size() == 0 ){
						$(this).parent().parent().siblings("input").attr("checked", false);
						
						var start = $(this).parent().parent();
						if( start.parent().siblings("li").children("input:checked").size() == 0 ){
							start.parent().parent().siblings("input").attr("checked", false);
						}
					}
				}
			});
			
		});
	</script>



</head>
<body>
	<s:form action="userAction_setPrivilege">
		<s:hidden name="id"></s:hidden>
		<table>
			<tbody>
				<%-- <input type="checkbox"
					onclick="$('[name=privilegeIds]').attr('checked',this.checked)" />
				<label for="cbSelectAll">全选</label>
				<s:checkboxlist name="privilegeIds" list="#privilegeList"
					listKey="id" listValue="name"></s:checkboxlist> --%>

				<ul id="root">
					<!--第一级  -->
					<s:iterator value="#topPrivilegeList">
						<li><input type="checkbox" name="privilegeIds" value="${id}"
							id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>  /> <label for="cb_${id}">${name}</label>
							<ul>
								<!--第二级  -->
								<s:iterator value="children">
									<li><input type="checkbox" name="privilegeIds"
										value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : '' }"/> /> <label for="cb_${id}">${name}</label>
										<br />
										<ul>
											<!--第三级  -->
											<s:iterator value="children">
												<li><input type="checkbox" name="privilegeIds"
													value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : '' }"/> /> <label for="cb_${id}">${name}</label>
													<br /></li>
											</s:iterator>
										</ul></li>
								</s:iterator>
							</ul></li>
					</s:iterator>
				</ul>

				<script type="text/javascript">
					$(function() {
						$("#root").treeview();
					});
				</script>



			</tbody>


		</table>

		<s:submit></s:submit>
	</s:form>




</body>


</html>


















































