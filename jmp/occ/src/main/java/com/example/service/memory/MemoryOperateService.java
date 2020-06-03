package com.example.service.memory;

import java.text.ParseException;
import java.util.List;

import com.example.entity.memory.SystemMemoryDBEntity;
import com.example.entity.memory.SystemMemoryIEntity;

/**
 * 内存操作
 * @Date 2020年5月8日
 * @author hxl
 *
 */
public interface MemoryOperateService {
	/**
	 * 添加内存
	 * @param smie   内存
	 * @throws ParseException 
	 */
    void memoryAdd(SystemMemoryIEntity smie) throws ParseException;
    /**
          * 获取监控系统内存信息列表
     * @param systemIds
     * @return
     */
    List<SystemMemoryDBEntity> memoryAllGet(List<String> systemIds);
    /**
          *   通过监控系统ID和时间段获取系统内存信息
     * @param systemIds 监控系统ID
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    List<SystemMemoryDBEntity> memoryGet(String systemIds,String startTime,String endTime);
}
