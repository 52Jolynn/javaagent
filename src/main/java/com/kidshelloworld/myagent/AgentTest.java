package com.kidshelloworld.myagent;

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
	}
}
