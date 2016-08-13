package com.xl.fm.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xl.fm.base.ModelDrivenBaseAction;
import com.xl.fm.domain.Match;
import com.xl.fm.util.HqlHelper;

@Controller
@Scope("prototype")
public class MatchAction extends ModelDrivenBaseAction<Match> {
	
	private Long timeOrder; // 排序条件 的变量
	
	
	public String addUI() throws Exception {
		
		return "addUI";
	}
	
	public String add() throws Exception {
		matchService.save(model);
		return "toList";
	}
	
	public String delete() throws Exception {
		Match match = matchService.getById(model.getId());
		matchService.delete(match);
		
		return "toList";
	}
	
	public String editUI() throws Exception {
		Match match = matchService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(match);
		
		return "editUI";
	}
	
	public String edit() throws Exception {
		matchService.update(model);
		return "toList";
	}
	
	public String list() throws Exception {
//		PageBean pageBean = matchService.getPageBean(pageNum);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		//准备分页信息，使用公共的方法
//		String hql = "FROM Match";
//		Object[] parameters = new Object[]{};
//		PageBean pageBean = matchService.getPageBean(pageNum, hql, parameters);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		HqlHelper hqlHelper = new HqlHelper(Match.class, "m")
						.addOrder(timeOrder != null && timeOrder==1, "m.matchTime", true)
						.addOrder(timeOrder != null && timeOrder==2, "m.matchTime", false);
		PageBean pageBean = matchService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		
		return "list";
	}

	public Long getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(Long timeOrder) {
		this.timeOrder = timeOrder;
	}
}


































