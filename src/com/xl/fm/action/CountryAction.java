package com.xl.fm.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xl.fm.base.ModelDrivenBaseAction;
import com.xl.fm.domain.Coach;
import com.xl.fm.domain.Country;
import com.xl.fm.domain.Match;
import com.xl.fm.domain.Player;
import com.xl.fm.util.HqlHelper;

@Controller
@Scope("prototype")
public class CountryAction extends ModelDrivenBaseAction<Country> {
	
	private Long coachId;
	private Long[] playerIds;
	private Long[] matchIds;
	
	private Long powerValue; //过滤条件 用的
	
	/**添加页面addUI */
	public String addUI() throws Exception {
		//准备数据
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		
		List<Player> playerList = playerService.findAll();
		ActionContext.getContext().put("playerList", playerList);
		
		List<Match> matchList = matchService.findAll();
		ActionContext.getContext().put("matchList", matchList);
		
		return "addUI";
	}
	/**添加 */
	public String add() throws Exception {
		//新建对象并设置属性，（也可以用model）
		Country country = new Country();
		country.setName(model.getName());
		country.setPower(model.getPower());
		
		Coach coach = coachService.getById(coachId);
		country.setCoach(coach);
		
		List<Player> playerList = playerService.getByIds(playerIds);
		country.setPlayers(new HashSet<Player>(playerList));
		
		List<Match> matchList = matchService.getByIds(matchIds);
		country.setMatches(new HashSet<Match>(matchList));
		
		//保存到数据库
		countryService.save(country);
		return "toList";
	}
	/**删除 */
	public String delete() throws Exception {
		Country country = countryService.getById(model.getId());
		countryService.delete(country);
		return "toList";
	}
	/**修改页面editUI */
	public String editUI() throws Exception {
		//准备数据
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		
		List<Player> playerList = playerService.findAll();
		ActionContext.getContext().put("playerList", playerList);
		
		List<Match> matchList = matchService.findAll();
		ActionContext.getContext().put("matchList", matchList);
		
		//准备回显的数据
		Country country = countryService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(country); 
		
		if(country.getCoach() != null) {
			coachId = country.getCoach().getId();
		}
		
		if (country.getPlayers().size() > 0) {
			playerIds = new Long[country.getPlayers().size()];
			int index = 0;
			for (Player player : country.getPlayers()) {
				playerIds[index++] = player.getId();
			}
		}
		
		if (country.getMatches().size() > 0) {
			matchIds = new Long[country.getMatches().size()];
			int index = 0;
			for (Match match : country.getMatches()){
				matchIds[index++] = match.getId();
			}
		}
		
		
		return "editUI";
	}
	/**修改 */
	public String edit() throws Exception {
		//从数据库中取出原对象
		Country country = countryService.getById(model.getId());
		//设置要更改的属性
		country.setName(model.getName());
		country.setPower(model.getPower());
		
		Coach coach = coachService.getById(coachId);
		country.setCoach(coach);
		
		List<Player> playerList = playerService.getByIds(playerIds);
		country.setPlayers(new HashSet<Player>(playerList));
		
		List<Match> matchList = matchService.getByIds(matchIds);
		country.setMatches(new HashSet<Match>(matchList));
		//更新到数据库
		countryService.update(country);
		
		return "toList";
	}
	/**列表 */
	public String list() throws Exception {
		//准备数据
//		List<Country> countryList = countryService.findAll();
//		ActionContext.getContext().put("countryList", countryList);
		//分页信息
		HqlHelper hqlHelper = new HqlHelper(Country.class, "c")
					.addOrder(powerValue != null && powerValue == 1, "c.power", true);
		
		PageBean pageBean = countryService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "list";
	}
	
	//=========================================================
	public Long getCoachId() {
		return coachId;
	}
	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}
	public Long[] getPlayerIds() {
		return playerIds;
	}
	public void setPlayerIds(Long[] playerIds) {
		this.playerIds = playerIds;
	}
	public Long[] getMatchIds() {
		return matchIds;
	}
	public void setMatchIds(Long[] matchIds) {
		this.matchIds = matchIds;
	}
	public Long getPowerValue() {
		return powerValue;
	}
	public void setPowerValue(Long powerValue) {
		this.powerValue = powerValue;
	}
	
	
	
	
}


































