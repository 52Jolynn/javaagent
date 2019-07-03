package com.kidshelloworld.myagent;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class Person2 {
	private String name;

	@Override
	public String toString() {
		return "name: " + name;
	}

	public void hello2(String name) {
		System.out.println(name);
	}
}
