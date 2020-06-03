package com.example.service.memory.impl;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.memory.SystemMemoryDBEntity;
import com.example.entity.memory.SystemMemoryIEntity;
import com.example.mapper.memory.MemoryOperateMapper;
import com.example.service.memory.MemoryOperateService;
import com.example.util.IEntityToDBEntityUtil;
@Service
public class MemoryOperateServiceImpl implements MemoryOperateService {
    @Autowired
    private MemoryOperateMapper  memoryOperateMapper;
	@Override
	public void memoryAdd(SystemMemoryIEntity smi) throws ParseException {
		  SystemMemoryDBEntity smdb=new SystemMemoryDBEntity();
          //SystemMemoryIEntity 转化为 SystemMemoryDBEntity
		  IEntityToDBEntityUtil.systemMemoryTo(smdb, smi);
		  //入库
		  memoryOperateMapper.memoryAdd(smdb);
	}
	@Override
	public List<SystemMemoryDBEntity> memoryAllGet(List<String> systemIds) {
		return memoryOperateMapper.memoryAllGet(systemIds);
	}
	@Override
	public List<SystemMemoryDBEntity> memoryGet(String systemId, String startTime, String endTime) {
		return memoryOperateMapper.memoryGet(systemId,startTime,endTime);
	}

}
