package com.xl.fm.cfg;

public class InitialCfg {
	
	private static int pageSize;
	
	static {
		//TODO 读取配置文件default.properties,并初始化所有配置
		pageSize = 2;
	}
	
	public static int getPageSize() {
		return pageSize;
	}
	
}
