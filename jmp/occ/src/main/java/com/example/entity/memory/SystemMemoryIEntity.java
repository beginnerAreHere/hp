package com.example.entity.memory;


/**
 * 系统内存(接口)
 * 
 * @Date 2020年5月7日
 * @author hxl
 *
 */
public class SystemMemoryIEntity {
	// 系统编码
	private String systemId;
	// JVM已用内存
	private String JVMUsedMemory;
	// JVM空闲内存
	private String JVMFreeMemory;
	// JVM总内存
	private String JVMTotalMemory;
	// JVM最大内存
	private String JVMMaxMemory;
	// 物理已用内存
	private String physicalUsedMemory;
	// 物理空闲内存
	private String physicalFreeMemory;
	// 物理总内存
	private String physicalTotalMemory;
	// 总线程数
	private String totalThread;
    //获取数据时间
    private String gainTime;
	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getJVMUsedMemory() {
		return JVMUsedMemory;
	}

	public void setJVMUsedMemory(String jVMUsedMemory) {
		JVMUsedMemory = jVMUsedMemory;
	}

	public String getJVMFreeMemory() {
		return JVMFreeMemory;
	}

	public void setJVMFreeMemory(String jVMFreeMemory) {
		JVMFreeMemory = jVMFreeMemory;
	}

	public String getJVMTotalMemory() {
		return JVMTotalMemory;
	}

	public void setJVMTotalMemory(String jVMTotalMemory) {
		JVMTotalMemory = jVMTotalMemory;
	}

	public String getJVMMaxMemory() {
		return JVMMaxMemory;
	}

	public void setJVMMaxMemory(String jVMMaxMemory) {
		JVMMaxMemory = jVMMaxMemory;
	}
   
	

	public String getPhysicalUsedMemory() {
		return physicalUsedMemory;
	}

	public void setPhysicalUsedMemory(String physicalUsedMemory) {
		this.physicalUsedMemory = physicalUsedMemory;
	}

	public String getPhysicalFreeMemory() {
		return physicalFreeMemory;
	}

	public void setPhysicalFreeMemory(String physicalFreeMemory) {
		this.physicalFreeMemory = physicalFreeMemory;
	}

	public String getPhysicalTotalMemory() {
		return physicalTotalMemory;
	}

	public void setPhysicalTotalMemory(String physicalTotalMemory) {
		this.physicalTotalMemory = physicalTotalMemory;
	}

	public String getTotalThread() {
		return totalThread;
	}

	public void setTotalThread(String totalThread) {
		this.totalThread = totalThread;
	}

	public String getGainTime() {
		return gainTime;
	}

	public void setGainTime(String gainTime) {
		this.gainTime = gainTime;
	}

	@Override
	public String toString() {
		return " {\"" + systemId + "\":'" + systemId + "', " + JVMUsedMemory + "\":'" + JVMUsedMemory + "', "
				+ JVMFreeMemory + "\":'" + JVMFreeMemory + "', " + JVMTotalMemory + "\":'" + JVMTotalMemory + "', "
				+ JVMMaxMemory + "\":'" + JVMMaxMemory + "', " + physicalUsedMemory + "\":'" + physicalUsedMemory
				+ "', " + physicalFreeMemory + "\":'" + physicalFreeMemory + "', " + physicalTotalMemory + "\":'"
				+ physicalTotalMemory + "', " + totalThread + "\":'" + totalThread + "', " + gainTime + "\":'"
				+ gainTime + "}";
	}

	
	
    
}
