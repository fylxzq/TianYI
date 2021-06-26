package com.fy.tianyi;

import java.util.ArrayList;
import java.util.List;


public class ParsedRespond {
	
	private String code;
	private List<ParsedStatus> deviceStatusList = new ArrayList<ParsedStatus>();
	private String desc;
	
	public ParsedRespond() {}
	public ParsedRespond(String code, List<ParsedStatus> deviceStatusList, String desc) {
		this.code = code;
		this.deviceStatusList = deviceStatusList;
		this.desc = desc;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public List<ParsedStatus> getDeviceStatusList() {
		return deviceStatusList;
	}
	
	public void setDeviceStatusList(List<ParsedStatus> deviceStatusList) {
		this.deviceStatusList = deviceStatusList;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "ParsedRespond\n"
				+ "[code=" + code + ",\n"
					+ "status_list=" + deviceStatusList + ",\n"
					+ "desc=" + desc + "]\n";
	}
}
