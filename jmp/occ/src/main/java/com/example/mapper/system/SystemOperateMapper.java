package com.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.entity.system.SystemDBEntity;
import com.example.entity.system.SystemIEntity;

/**
 * 监控系统操作 Mapper
 * @Date 2020年5月11日
 * @author hxl
 *
 */
@Mapper
public interface SystemOperateMapper {
	   /**
	    * 添加监控系统
	    * @param sdbe 监控系统
	    */
       void  systemAdd(@Param("system")SystemDBEntity sdbe);
       /**
                * 根据系统ID判断监控系统是否存在
        * @param systemId
        * @return
        */
       @Select("SELECT SYSTEM_ID AS 'systemId',SYSTEM_NAME AS 'systemName' FROM OCC_SYSTEM WHERE SYSTEM_ID =#{systemId} LIMIT 1")
       SystemDBEntity systemExit(@Param("systemId")String systemId);
       
       List<SystemIEntity> systemGet(@Param("systemId")String systemId);
       
}
