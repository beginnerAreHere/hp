package com.example.entity.system;

/**
 * 监控系统接口class
 * 
 * @Date 2020年5月11日
 * @author hxl
 *
 */
public class SystemIEntity {
	// 系统ID
	private String systemId;
	// 系统名称
	private String systemName;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	@Override
	public String toString() {
		return " {\"" + systemId + "\":'" + systemId + "', " + systemName + "\":'" + systemName + "}";
	}
	

}
