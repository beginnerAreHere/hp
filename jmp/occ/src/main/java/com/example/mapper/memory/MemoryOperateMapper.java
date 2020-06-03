package com.example.mapper.memory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.memory.SystemMemoryDBEntity;

/**
 * 
 * @Date 2020年5月8日
 * @author hxl
 *
 */
@Mapper
public interface MemoryOperateMapper {
	/**
	 * 内存添加
	 * @param smie
	 */
    void memoryAdd(@Param(value="smdb")SystemMemoryDBEntity smdb);
    /**
          * 获取监控信息内存信息
     * @param systemIds
     * @return
     */
    List<SystemMemoryDBEntity> memoryAllGet(@Param(value="systemIds")List<String> systemIds);
    /**
           *  通过 监控系统ID和时间段获取内存信息
     * @param systemId
     * @param startTime
     * @param endTime
     * @return
     */
    List<SystemMemoryDBEntity> memoryGet(@Param(value="systemId")String systemId,@Param(value="startTime")String startTime,@Param(value="endTime")String endTime);
}
