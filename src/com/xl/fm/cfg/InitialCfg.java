package com.xl.fm.cfg;

public class InitialCfg {
	
	private static int pageSize;
	
	static {
		//TODO ��ȡ�����ļ�default.properties,����ʼ����������
		pageSize = 2;
	}
	
	public static int getPageSize() {
		return pageSize;
	}
	
}
