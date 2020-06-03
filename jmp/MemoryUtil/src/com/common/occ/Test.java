package com.common.occ;

public class Test {

	public static void main(String[] args) {
		String systemId="033d9ff0-7049-4af9-a599-314abddc34c1";
		String url="http://127.0.0.1:8001/memory/add";
		int milliseconds=1000*30;
		MemorySendEntrance.timedSend(systemId,url,milliseconds);
	}

}
