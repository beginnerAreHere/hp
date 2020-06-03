package com.common.occ;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.management.OperatingSystemMXBean;

@SuppressWarnings("restriction")
public class MemorySendEntrance {
    /**
          *   定时发送内存信息
     * @param systemId  监控系统ID
     * @param url       监控地址
     * @param milliseconds  定时间隔 毫秒
     */
	public static void timedSend(String systemId,String url,long milliseconds){
		Timer timer=new Timer();
		TimerTask  timeTask=new TimerTask(){
			@Override
			public void run() {  
				// 虚拟机级内存情况查询
				long vmFree = 0;
				long vmUse = 0;
				long vmTotal = 0;
				long vmMax = 0;
				int byteToMb = 1024 * 1024;
				Runtime rt = Runtime.getRuntime();
				vmTotal = rt.totalMemory() / byteToMb;
				vmFree = rt.freeMemory() / byteToMb;
				vmMax = rt.maxMemory() / byteToMb;
				vmUse = vmTotal - vmFree;
				// 操作系统级内存情况查询
				OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
				long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
				long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
				long physicalUse = physicalTotal - physicalFree;
				// 获得线程总数
				ThreadGroup parentThread;
				int totalThread = 0;
				for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
						.getParent() != null; parentThread = parentThread.getParent()) {
					totalThread = parentThread.activeCount();
				}  
				
				String param="{\r\n" + 
				"    \"systemId\":\""+systemId+"\",\r\n" + 
         		"    \"JVMUsedMemory\":\""+vmUse+"\",\r\n" + 
         		"    \"JVMFreeMemory\":\""+vmFree+"\",\r\n" + 
         		"    \"JVMTotalMemory\":\""+vmTotal+"\",\r\n" + 
         		"    \"JVMMaxMemory\":\""+vmMax+"\",\r\n" + 
         		"    \"PhysicalUsedMemory\":\""+physicalUse+"\",\r\n" + 
         		"    \"PhysicalFreeMemory\":\""+physicalFree+"\",\r\n" +
         		"    \"PhysicalTotalMemory\":\""+physicalTotal+"\",\r\n" +
         		"    \"TotalThread\":\""+totalThread+"\",\r\n" +
         		"    \"GainTime\":\""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"\"\r\n" +
         		"}";
				HttpUtils.sendPost(url, param);
	        } 
		};
		timer.schedule(timeTask,0,milliseconds);
	}

}
