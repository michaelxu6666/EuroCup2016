package com.xl.fm.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xl.fm.base.ModelDrivenBaseAction;
import com.xl.fm.domain.Privilege;
import com.xl.fm.domain.User;
import com.xl.fm.util.HqlHelper;

@Controller
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<User> {

	private Long[] privilegeIds;

	public String list() throws Exception {

		HqlHelper hqlHelper = new HqlHelper(User.class, "u");

		PageBean pageBean = userService.getPageBean(pageNum, hqlHelper);

		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	public String addUI() throws Exception {

		return "addUI";
	}

	public String add() throws Exception {
		model.setPassword("1234");
		userService.save(model);
		return "toList";
	}

	public String delete() throws Exception {
		// userService.delete(model);

		User user = userService.getById(model.getId());
		userService.delete(user);

		return "toList";
	}

	public String editUI() throws Exception {
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "editUI";
	}

	public String edit() throws Exception {
		User user = userService.getById(model.getId());

		user.setName(model.getName());
		user.setLoginName(model.getLoginName());
		user.setGender(model.getGender());

		userService.update(user);
		return "toList";
	}

	public String setPrivilegeUI() throws Exception {
		//�����ݿ���ȡ������Ȩ��
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivilege();

		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);


		// ׼����������
		// �����ݿ���ȡ��Ҫ�޸ĵĶ���
		User user = userService.getById(model.getId());
		// ȡ�����û�ӵ�е�Ȩ��
		Set<Privilege> userPrivilegeList = user.getPrivileges();

		privilegeIds = new Long[userPrivilegeList.size()];
System.out.println("�û�Ȩ�޵ĸ��� " + userPrivilegeList.size());
		int index = 0;
		for (Privilege p : userPrivilegeList) {
				privilegeIds[index++] = p.getId();
			}
		

		return "setPrivilegeUI";
	}

	public String setPrivilege() throws Exception {

		Set<Privilege> privilegeList = new HashSet<Privilege>(
				privilegeService.getByIds(privilegeIds));

		User user = userService.getById(model.getId());

		user.setPrivileges(privilegeList);

		userService.update(user);

		// ����ֱ��ʹ��model�ķ��������У� ��Ҫ���ݴ������� id �����ݿ���ȡ��ԭ���� ���������Բ����棡
		/*
		 * model.setPrivileges(privilegeList);
		 * System.out.println("id--1 " + model.getId());
		 * userService.save(model); 
		 * System.out.println("id--2 " + model.getId()); // id--1 �� id--2 ��ֵ��һ������ ���е�model ������ id--1
		 * ���е�model !!! // model ֻ��������װ ��Action�е����Եģ� ��Jsp --> Action (model
		 * --1) ,�ڴ�Action --> Jsp ��model --2�� ;����������model �ǲ�ͬ�Ķ���ʵ�� ���ܻ��Ⱥŵģ���
		 */
		return "toList";
	}
	
	
	/** ��½ҳ�� */
	public String loginUI() throws Exception {
		
		return "loginUI";
	}
	
	/** ��½ */
	public String login() throws Exception {
		
		// �����û���������ȡ�����ݿ��е��û�
		User user = userService.getByNameAndPassword(model.getLoginName(),model.getPassword());
System.out.println("�����û���������ȡ�����û� = " + user);
			//1���û�Ϊ�գ�������ʾ���� ���û������������
			if (user == null) {
				addFieldError("loginName","�û�����������󣡣�");
				return "loginUI";
			} else {
				//2����ȡ�����û��ŵ� Session��
				ActionContext.getContext().getSession().put("user", user);
//System.out.println("���û���Ӧ��Ȩ�� =" + user.getPrivileges());
				return "toIndex";
			}
	}
	/** ע�� */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	
	

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
