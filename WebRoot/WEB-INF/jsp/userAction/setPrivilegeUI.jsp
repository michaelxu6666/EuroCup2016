<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>�û�Ȩ������</title>
<%@include file="/WEB-INF/jsp/public/common.jspf"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<script language="javascript"
	src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />

<script type="text/javascript">
		$(function(){
			
			// �����е�Ȩ�޸�ѡ������¼�
			$("[name=privilegeIds]").click(function(){

				// �Լ�ѡ�л�ȡ��ʱ�������е��¼�Ȩ��Ҳ��ͬʱѡ�л�ȡ��
				$(this).siblings("ul").find("input").attr("checked", this.checked);
				
				// ��ѡ��һ��Ȩ��ʱ��ҲҪͬʱѡ�����е�ֱϵ�ϼ�Ȩ��
				if(this.checked){
					$(this).parents("li").children("input").attr("checked", true);
				}
				// ��ȡ��һ��Ȩ��ʱ��ͬ��û��ѡ�е�Ȩ���ˣ���Ҳȡ�������ϼ�Ȩ�ޣ�������Ҳ��������
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
				<label for="cbSelectAll">ȫѡ</label>
				<s:checkboxlist name="privilegeIds" list="#privilegeList"
					listKey="id" listValue="name"></s:checkboxlist> --%>

				<ul id="root">
					<!--��һ��  -->
					<s:iterator value="#topPrivilegeList">
						<li><input type="checkbox" name="privilegeIds" value="${id}"
							id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>  /> <label for="cb_${id}">${name}</label>
							<ul>
								<!--�ڶ���  -->
								<s:iterator value="children">
									<li><input type="checkbox" name="privilegeIds"
										value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : '' }"/> /> <label for="cb_${id}">${name}</label>
										<br />
										<ul>
											<!--������  -->
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


















































