package com.xl.fm.action;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xl.fm.base.ModelDrivenBaseAction;
import com.xl.fm.domain.Coach;
import com.xl.fm.domain.Country;
import com.xl.fm.domain.Player;
import com.xl.fm.util.HqlHelper;

@Controller
@Scope("prototype")
public class PlayerAction extends ModelDrivenBaseAction<Player>{
	
	private Long coachId;
	private Long countryId;
	
	private int powerValue=3;
	
	private Long countryNo;
	
	/**
	 *  列表页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		//准备分页相关信息 PageBean
//		PageBean pageBean = playerService.getPageBean(pageNum);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		//准备分页信息，使用公共的方法
//		String hql ="";
//		if (beyondAge != null) {
//			if(beyondAge == 1) {
//				hql = "FROM Player p WHERE p.age >= 30 ";
//			} else if(beyondAge == 2) {
//				hql = "FROM Player p WHERE p.age <= 20 ";
//			}
//		}
//		else {
//			hql = "FROM Player ";
//		}
//		Object[] parameters = new Object[]{};
//		PageBean pageBean = playerService.getPageBean(pageNum, hql, parameters);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		//最终版
		//准备过滤条件需要的数据
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		
		HqlHelper hqlHelper = new HqlHelper(Player.class, "p")
					.addCondition(countryNo != null && countryNo != -1,"countryId=?", countryNo)// -1代表select默认显示的值
					.addOrder(powerValue==1,"p.power",false)
					.addOrder(powerValue==2, "p.power", true);
			
					
		PageBean pageBean = playerService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "list";
	}
	/**
	 * 添加页面	addUI
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		// 准备数据
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		
		return "addUI";
	}
	/**
	 * 添加	
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		//新建对象，并设置属性
		model.setPower(90);
		Country country = countryService.getById(countryId);
		model.setCountry(country);
		Coach coach = coachService.getById(coachId);
		model.setCoach(coach);
		
		//保存到数据库
		playerService.save(model);
		return "toList";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		Player player = playerService.getById(model.getId());
		playerService.delete(player);
		return "toList";
	}
	
	/**
	 * 修改页面 editUI
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		//准备国家相关的数据
		// 准备数据
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		//准备教练相关的数据
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		//准备回显的数据 
		Player player = playerService.getById(model.getId());
		if (player.getCountry() != null) {
			countryId = player.getCountry().getId();
		}
		if(player.getCoach() != null) {
			coachId = player.getCoach().getId();
		}
		ActionContext.getContext().getValueStack().push(player);
		return "editUI";
	}
	
	
	public String edit() throws Exception {
		//取出原对象，并设置修改后的属性
		Player player = playerService.getById(model.getId());
		player.setName(model.getName());
		player.setAge(model.getAge());
		player.setPower(model.getPower());
		
		Country country = countryService.getById(countryId);
		player.setCountry(country);
		
		Coach coach = coachService.getById(coachId);
		player.setCoach(coach);
		
		//更新到数据库
		playerService.update(player);
		return "toList";
	}

//=====================================================

	public Long getCoachId() {
		return coachId;
	}
	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public int getPowerValue() {
		return powerValue;
	}
	public void setPowerValue(int powerValue) {
		this.powerValue = powerValue;
	}
	public Long getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(Long countryNo) {
		this.countryNo = countryNo;
	}
	

	
	
}
