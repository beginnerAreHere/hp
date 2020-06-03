package com.example.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.common.constant.ResposeEnum;
import com.example.entity.common.CommonResposeEntity;
import com.example.entity.system.SystemIEntity;
import com.example.service.system.SystemService;
/**
 * 监控系统相关操作
 * @Date 2020年5月11日
 * @author hxl
 *
 */
@RestController
public class SystemController {
	 @Autowired
	 private SystemService systemService;
	 /**
	    *  添加监控系统
	  * @param system
	  * @return
	  */
	 @RequestMapping(value="/system/add" )
      public CommonResposeEntity systemAdd(@RequestBody String system) {
    	  CommonResposeEntity cre=new CommonResposeEntity();
    	  if(system==null||"".equals(system)) {
  			cre.SetCodeMessage(ResposeEnum.ParamNullException);
  			return cre;
  		  }
    	  SystemIEntity sie=JSON.parseObject(system,SystemIEntity.class);
    	  systemService.systemAdd(sie);
    	  cre.setData(sie);
    	  return cre;
      }
	 /**
	  * 
	  * @param systemId
	  * @return
	  */
	 @RequestMapping(value="/system/get" )
     public CommonResposeEntity systemGet(String systemId) {
   	  CommonResposeEntity cre=new CommonResposeEntity();
   	  List<SystemIEntity> sies=systemService.systemGet(systemId);
   	  cre.setData(sies);
   	  return cre;
     }
	 
}
