package com.framework.test.util;

public class SyncUtil {

	public static void wait(int sec) {
	try {
		Thread.sleep(sec*1000);
	}	
	catch (InterruptedException e){
		e.printStackTrace();
	}
	}
}
