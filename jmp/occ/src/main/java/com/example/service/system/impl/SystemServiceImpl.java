package com.example.service.system.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.system.SystemDBEntity;
import com.example.entity.system.SystemIEntity;
import com.example.mapper.system.SystemOperateMapper;
import com.example.service.system.SystemService;
import com.example.util.IEntityToDBEntityUtil;
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemOperateMapper som;
	@Override
	@Transactional(
    rollbackFor= {Exception.class},//导致事务回滚的异常类数组
    //rollbackForClassName= {"Exception"},
    //rollbackForClassName  导致事务回滚的异常类名字数组
    //noRollbackFor=Exception.class,//导致事务回滚的异常类数组
    //noRollbackForClassName  导致事务回滚的异常类名字数组
	propagation=Propagation.REQUIRED,//可选的事务传播行为设置
	isolation=Isolation.DEFAULT,//默认为底层数据库的事务隔离级别
	readOnly=false //读写或只读事务，默认读写
	)
	// 注解什么场景会失效：只能修饰 public   没指定rollbackFor时  checkException不回滚
	public SystemIEntity systemAdd(SystemIEntity sie) {
		String systemId=sie.getSystemId();
		//判断systemId参数是否有值
		if(systemId==null||"".equals(systemId)) {
			sie.setSystemId(UUID.randomUUID().toString());
			SystemDBEntity sdbe=new SystemDBEntity();
			IEntityToDBEntityUtil.systemTo(sdbe, sie);
			som.systemAdd(sdbe);
		}else {
			//判断systemId 是否已经存在
			SystemDBEntity exitSystem=som.systemExit(systemId);
			//不存在
			if(exitSystem==null) {
				sie.setSystemId("");
				sie.setSystemName("");
			}else{
				sie.setSystemName(exitSystem.getSystemName());
			}
		}
		return sie;
	}
	@Override
	public SystemDBEntity systemExit(String systemId) {
		return som.systemExit(systemId);
	}
	@Override
	public List<SystemIEntity> systemGet(String systemId) {
		return som.systemGet(systemId);
	}

}
