
package com.xl.fm.action;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	
	public String test() throws Exception {
System.out.println("�Ƿ������� ʱ��=" + new Date() );
		return "test";
	}
	
}
