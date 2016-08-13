package com.xl.fm.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xl.fm.domain.User;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//System.out.println("===����֮ǰ===");
//
//	invocation.invoke();
//
//System.out.println("===����֮��===");
//		
		// ��ȡ��ǰ�û�
				User user = (User) ActionContext.getContext().getSession().get("user");

				// ��ȡ��ǰ���ʵ�URL����ȥ����ǰӦ�ó����ǰ׺��Ҳ���� namespaceName + actionName ��
				String namespace = invocation.getProxy().getNamespace();
				String actionName = invocation.getProxy().getActionName();
				String privilegeUrl = null;
				if (namespace.endsWith("/")) {
					privilegeUrl = namespace + actionName;
				} else {
					privilegeUrl = namespace + "/" + actionName;
				}

				// Ҫȥ����ͷ��'/'
				if (privilegeUrl.startsWith("/")) {
					privilegeUrl = privilegeUrl.substring(1);
				}

				// ���δ��¼�û�
				if (user == null) {
					if (privilegeUrl.startsWith("userAction_login")) { // userAction_login, userAction_loginUI
						// ���������ʹ�õ�¼���ܣ��ͷ���
						return invocation.invoke();
					} else {
						// �������ȥ��¼����ת����¼ҳ��
						return "loginUI";
					}
				}
				// ����ѵ�¼�û������ж�Ȩ�ޣ�
				else {
					if (user.hasPrivilegeUrl(privilegeUrl)) {
						// �����Ȩ�ޣ��ͷ���
						return invocation.invoke();
					} else {
						// ���û��Ȩ�ޣ���ת����ʾҳ��
						return "noPrivilegeError";
					}
				}
//		
		
	}

}
