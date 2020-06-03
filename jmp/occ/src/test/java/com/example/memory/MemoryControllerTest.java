package com.example.memory;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Application;
import com.example.entity.memory.SystemMemoryIEntity;
import com.example.service.memory.MemoryOperateService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class MemoryControllerTest {
	@Autowired
	private MemoryOperateService memoryOperateService;

	@Test
	public void TestMemoryAdd() {
		// MemoryOperateController mc=new MemoryOperateController();
		// 内存接口对象
		SystemMemoryIEntity sie = new SystemMemoryIEntity();
		// uuid
		//sie.setId(UUID.randomUUID().toString());
		sie.setJVMFreeMemory("1000");
		sie.setJVMMaxMemory("2000");
		sie.setJVMTotalMemory("2000");
		sie.setJVMUsedMemory("1000");
		sie.setPhysicalFreeMemory("1000");
		sie.setPhysicalTotalMemory("2000");
		sie.setPhysicalUsedMemory("1000");
		sie.setSystemId("1234567");
		sie.setTotalThread("100");
		sie.setGainTime("2020-05-14 00:00:00");
		try {
			memoryOperateService.memoryAdd(sie);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
