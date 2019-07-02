package com.kidshelloworld.myagent;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class AgentTest {
	public static void main(String[] args) throws Exception {
		String name = "agent";
		Person person = new Person();
		System.out.print("invoke hello: ");
		Person.class.getMethod("hello", String.class).invoke(person, name);
		System.out.println(new File("e:\\"));
		while(true) {
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
