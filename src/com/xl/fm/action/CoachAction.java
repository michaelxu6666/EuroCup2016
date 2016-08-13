package com.xl.fm.action;

import java.util.HashSet;
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
public class CoachAction extends ModelDrivenBaseAction<Coach> {
	private Long countryId;
	private Long[] playerIds;
	
	
	public String addUI() throws Exception {
		//准备数据
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		List<Player> playerList = playerService.findAll();
		ActionContext.getContext().put("playerList", playerList);
		return "addUI";
	}
	
	public String add() throws Exception {
		//新建对象并设置属性
		Coach coach = new Coach();
		coach.setName(model.getName());
		coach.setAge(model.getAge());
		
		Country country = countryService.getById(countryId);
		coach.setCountry(country);
		
		List<Player> playerList = playerService.getByIds(playerIds);
		coach.setPlayers(new HashSet<Player>(playerList));
		
		//保存到数据库
		coachService.save(coach);
		
		return "toList"; 
	}
	
	public String delete() throws Exception {
		// 从数据库中取出原对象
		Coach coach = coachService.getById(model.getId());
		//删除对象
		coachService.delete(coach);
		
		
		return "toList";
	}
	
	public String editUI() throws Exception {
		//准备数据
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		List<Player> playerList = playerService.findAll();
		ActionContext.getContext().put("playerList", playerList);
		
		//准备回显的数据
		Coach coach = coachService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(coach);
		
		if (coach.getCountry() != null) {
			countryId = coach.getCountry().getId();
		}
		
		if(coach.getPlayers().size() > 0) {
			playerIds = new Long[coach.getPlayers().size()];
			int index = 0;
			for (Player player : coach.getPlayers()) {
				playerIds[index++] = player.getId();
			}
		}
		return "editUI";
	}
	
	public String edit() throws Exception {
		//取出原对象，设置属性
		Coach coach = coachService.getById(model.getId());
		
		coach.setName(model.getName());
		coach.setAge(model.getAge());
		
		Country country = countryService.getById(countryId);
		coach.setCountry(country);
		
		List<Player> playerList = playerService.getByIds(playerIds);
		coach.setPlayers(new HashSet<Player>(playerList));
		
		//更新到数据库
		coachService.update(coach);
		
		return "toList";
	}
	
	public String list() throws Exception {
//		List<Coach> coachList = coachService.findAll();
//		ActionContext.getContext().put("coachList", coachList);
		
		//分页信息
		HqlHelper hqlHelper = new HqlHelper(Coach.class, "c");
		
		PageBean pageBean = coachService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		
		return "list";
	}

//=========================================================
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long[] getPlayerIds() {
		return playerIds;
	}

	public void setPlayerIds(Long[] playerIds) {
		this.playerIds = playerIds;
	}
	
	

}



































