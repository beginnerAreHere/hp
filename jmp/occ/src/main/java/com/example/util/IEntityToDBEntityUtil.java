package com.example.util;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import com.example.entity.memory.SystemMemoryDBEntity;
import com.example.entity.memory.SystemMemoryIEntity;
import com.example.entity.system.SystemDBEntity;
import com.example.entity.system.SystemIEntity;

/**
 * 接口类转化为入库类
 * @Date 2020年5月8日
 * @author hxl
 *
 */
public class IEntityToDBEntityUtil {
	 /**
	  * 系统内存转化
	  * @param smdb 入库类
	  * @param smi  接口类
	  * @throws ParseException  转化异常
	  */
     public static void systemMemoryTo(SystemMemoryDBEntity smdb,SystemMemoryIEntity smi) throws ParseException {
    	 smdb.setId(UUID.randomUUID().toString());
    	 smdb.setSystemId(smi.getSystemId());
    	 smdb.setJVMFreeMemory(smi.getJVMFreeMemory());
    	 smdb.setJVMMaxMemory(smi.getJVMMaxMemory()); 
    	 smdb.setJVMTotalMemory(smi.getJVMTotalMemory());
    	 smdb.setJVMUsedMemory(smi.getJVMUsedMemory());
    	 smdb.setPhysicalFreeMemory(smi.getPhysicalFreeMemory());
    	 smdb.setPhysicalTotalMemory(smi.getPhysicalTotalMemory());
    	 smdb.setPhysicalUsedMemory(smi.getPhysicalUsedMemory());
    	 smdb.setTotalThread(smi.getTotalThread());
    	 smdb.setGainTime(DateUtil.STD_YMDToDate(smi.getGainTime()));
    	 smdb.setDbTime(new Date());
     }
     /**
      * 监控系统转化
      * @param sdbe 入库类
      * @param sie  接口类
      */
     public static void systemTo(SystemDBEntity sdbe,SystemIEntity sie) {
    	 sdbe.setSystemId(sie.getSystemId());
    	 sdbe.setSystemName(sie.getSystemName());
    	 sdbe.setDBTime(new Date());
     }
}
