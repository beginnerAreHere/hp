package com.example.service.system;

import java.util.List;

import com.example.entity.system.SystemDBEntity;
import com.example.entity.system.SystemIEntity;

/**
 * 监控系统操作
 * 
 * @Date 2020年5月11日
 * @author hxl
 *
 */
public interface SystemService {
	/**
	 * 添加监控系统
	 * 
	 * @param se 监控系统
	 * @return
	 */
	SystemIEntity systemAdd(SystemIEntity se);

	/**
	 * 通过监控系统ID确定监控系统是否存在
	 * 
	 * @param systemId
	 * @return
	 */
	SystemDBEntity systemExit(String systemId);
    /**
          * 通过监控系统ID获取监控系统信息
     * @param systemId
     * @return
     */
	List<SystemIEntity> systemGet(String systemId);
}
