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
	 *  �б�ҳ��
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		//׼����ҳ�����Ϣ PageBean
//		PageBean pageBean = playerService.getPageBean(pageNum);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		//׼����ҳ��Ϣ��ʹ�ù����ķ���
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
		
		//���հ�
		//׼������������Ҫ������
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		
		HqlHelper hqlHelper = new HqlHelper(Player.class, "p")
					.addCondition(countryNo != null && countryNo != -1,"countryId=?", countryNo)// -1����selectĬ����ʾ��ֵ
					.addOrder(powerValue==1,"p.power",false)
					.addOrder(powerValue==2, "p.power", true);
			
					
		PageBean pageBean = playerService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "list";
	}
	/**
	 * ���ҳ��	addUI
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		// ׼������
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		
		return "addUI";
	}
	/**
	 * ���	
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		//�½����󣬲���������
		model.setPower(90);
		Country country = countryService.getById(countryId);
		model.setCountry(country);
		Coach coach = coachService.getById(coachId);
		model.setCoach(coach);
		
		//���浽���ݿ�
		playerService.save(model);
		return "toList";
	}
	
	/**
	 * ɾ��
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		Player player = playerService.getById(model.getId());
		playerService.delete(player);
		return "toList";
	}
	
	/**
	 * �޸�ҳ�� editUI
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		//׼��������ص�����
		// ׼������
		List<Country> countryList = countryService.findAll();
		ActionContext.getContext().put("countryList", countryList);
		//׼��������ص�����
		List<Coach> coachList = coachService.findAll();
		ActionContext.getContext().put("coachList", coachList);
		//׼�����Ե����� 
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
		//ȡ��ԭ���󣬲������޸ĺ������
		Player player = playerService.getById(model.getId());
		player.setName(model.getName());
		player.setAge(model.getAge());
		player.setPower(model.getPower());
		
		Country country = countryService.getById(countryId);
		player.setCountry(country);
		
		Coach coach = coachService.getById(coachId);
		player.setCoach(coach);
		
		//���µ����ݿ�
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
