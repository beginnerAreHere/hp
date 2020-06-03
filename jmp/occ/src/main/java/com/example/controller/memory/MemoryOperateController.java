package com.example.controller.memory;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.common.constant.ResposeEnum;
import com.example.entity.common.CommonResposeEntity;
import com.example.entity.memory.SystemMemoryDBEntity;
import com.example.entity.memory.SystemMemoryIEntity;
import com.example.entity.system.SystemDBEntity;
import com.example.service.memory.MemoryOperateService;
import com.example.service.system.SystemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 系统内存操作Controller
 * @Date 2020年5月7日
 * @author hxl
 *
 */
@RestController
@Api("系统内存操作Controller")
public class MemoryOperateController {
	@Autowired
	private MemoryOperateService  memoryOperateService;
	@Autowired
	private SystemService systemService;
	/**
	 * 添加系统内存信息
	 * @param smie
	 * @return
	 */
	@ApiOperation("添加系统内存信息")
	@RequestMapping(value="/memory/add",method=RequestMethod.POST)
	public CommonResposeEntity memoryAdd(@RequestBody String smies) {
		CommonResposeEntity cre=new CommonResposeEntity();
		if(smies==null||"".equals(smies)) {
			cre.SetCodeMessage(ResposeEnum.ParamNullException);
			return cre;
		}
		//string 转化为对应的对象
		SystemMemoryIEntity smie=JSON.parseObject(smies,SystemMemoryIEntity.class);
		//判断监控系统是否存在
		String systemId=smie.getSystemId();
		//通过监控系统ID获取
		SystemDBEntity sdbe=systemService.systemExit(systemId);
		if(sdbe==null) {
			ResposeEnum.CommonError.setMessage("监控系统不存在");
			cre.SetCodeMessage(ResposeEnum.CommonError);
			return cre;
		}
		try { 
			memoryOperateService.memoryAdd(smie);
	    } catch (ParseException e) {
			//日期转化错误
			cre.SetCodeMessage(ResposeEnum.DateParseException);
		}
		return cre;
	}
	/**
	 * 根据系统ID获取系统内存信息
	 * @param systemId
	 * @return
	 */
	@ApiOperation("根据系统ID获取系统内存信息")
	@RequestMapping(value="/memory/allGet",method=RequestMethod.POST)
	public CommonResposeEntity  memoryAllGet(@RequestBody List<String> systemIds) {
		CommonResposeEntity cre=new CommonResposeEntity();
		if(systemIds==null) {
			cre.SetCodeMessage(ResposeEnum.ParamNullException);
			return cre;
		}
		List<SystemMemoryDBEntity> smdbs=memoryOperateService.memoryAllGet(systemIds);
		cre.setData(smdbs);
		return cre;
	}
	
	
	/**
	 *   根据系统ID 时间段获取系统内存信息
	 * @param systemId  系统ID
	 * @param startTime  开始时间 yyyy-MM-dd HH:mm:ss
	 * @param endTime    结束时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@ApiOperation("根据系统ID获取系统内存信息")
	@RequestMapping(value="/memory/get",method=RequestMethod.POST)
	public CommonResposeEntity  memoryGet(String systemId,String startTime,String endTime ) {
		CommonResposeEntity cre=new CommonResposeEntity();
		//systemId 为null
		if(systemId==null) {
			ResposeEnum.ParamNullException.setMessage("systemId为空");
			cre.SetCodeMessage(ResposeEnum.ParamNullException);
			return cre;
		}
		//startTime 为null
		if(startTime==null||"".equals(startTime)) {
			ResposeEnum.ParamNullException.setMessage("startTime为空");
			cre.SetCodeMessage(ResposeEnum.ParamNullException);
			return cre;
		}
		List<SystemMemoryDBEntity> smdbs=memoryOperateService.memoryGet(systemId,startTime,endTime);
		cre.setData(smdbs);
		return cre;
	}
}
