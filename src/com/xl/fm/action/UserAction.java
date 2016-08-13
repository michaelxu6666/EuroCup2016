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
		//从数据库中取出顶级权限
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivilege();

		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);


		// 准备回显数据
		// 从数据库中取出要修改的对象
		User user = userService.getById(model.getId());
		// 取出该用户拥有的权限
		Set<Privilege> userPrivilegeList = user.getPrivileges();

		privilegeIds = new Long[userPrivilegeList.size()];
System.out.println("用户权限的个数 " + userPrivilegeList.size());
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

		// 这种直接使用model的方法不可行！ 需要根据传过来的 id 从数据库中取出原对象 再设置属性并保存！
		/*
		 * model.setPrivileges(privilegeList);
		 * System.out.println("id--1 " + model.getId());
		 * userService.save(model); 
		 * System.out.println("id--2 " + model.getId()); // id--1 和 id--2 的值不一样！！ 该行的model 覆盖了 id--1
		 * 行中的model !!! // model 只是用来封装 本Action中的属性的， 从Jsp --> Action (model
		 * --1) ,在从Action --> Jsp （model --2） ;生成了两个model 是不同的对象实例 不能画等号的！！
		 */
		return "toList";
	}
	
	
	/** 登陆页面 */
	public String loginUI() throws Exception {
		
		return "loginUI";
	}
	
	/** 登陆 */
	public String login() throws Exception {
		
		// 根据用户名和密码取出数据库中的用户
		User user = userService.getByNameAndPassword(model.getLoginName(),model.getPassword());
System.out.println("根据用户名和密码取出的用户 = " + user);
			//1、用户为空，弹出提示错误 ‘用户名或密码错误’
			if (user == null) {
				addFieldError("loginName","用户名或密码错误！！");
				return "loginUI";
			} else {
				//2、将取出的用户放到 Session中
				ActionContext.getContext().getSession().put("user", user);
//System.out.println("该用户对应的权限 =" + user.getPrivileges());
				return "toIndex";
			}
	}
	/** 注销 */
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
