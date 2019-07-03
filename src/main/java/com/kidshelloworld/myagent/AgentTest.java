package com.kidshelloworld.myagent;

import java.util.concurrent.Executors;
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
		try {
			Person.class.getMethod("hello", String.class).invoke(person, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Person2 person2 = new Person2();
		Executors.newScheduledThreadPool(1).schedule(() -> {
			try {
				Person2.class.getMethod("hello2", String.class).invoke(person2, name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 10, TimeUnit.SECONDS);
		while (true) {
			TimeUnit.MILLISECONDS.sleep(10);
		}
	}
}
