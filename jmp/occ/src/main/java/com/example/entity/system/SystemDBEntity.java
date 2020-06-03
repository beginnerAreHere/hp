package com.example.entity.system;

import java.util.Date;

import com.example.util.DateUtil;

/**
 * 监控系统DB class
 * 
 * @Date 2020年5月11日
 * @author hxl
 *
 */
public class SystemDBEntity {
	// 系统ID
	private String systemId;
	// 系统名称
	private String systemName;
	// 生成时间
    private Date DBTime;
	
    

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

	public Date getDBTime() {
		return DBTime;
	}

	public void setDBTime(Date dBTime) {
		DBTime = dBTime;
	}

	@Override
	public String toString() {
		return " {\"" + systemId + "\":'" + systemId + "', " + systemName + "\":'" + systemName + "', " + DBTime
				+ "\":'" + DateUtil.dateToSTD_YMD(DBTime) + "}";
	}
    
	



	
	

}
