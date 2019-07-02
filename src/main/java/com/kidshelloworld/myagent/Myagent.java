package com.kidshelloworld.myagent;

import java.lang.instrument.Instrumentation;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class Myagent {
	public static void premain(String agentOps, Instrumentation inst) {
		System.out.println("=========premain execute========");
		System.out.println("agentOps: " + agentOps);
		inst.addTransformer(new MyTransformer());
		System.out.println("=========premain execute end========");
	}

	public static void premain(String agentOps) {
		System.out.println("====premain execute2====");
		System.out.println("agentOps: " + agentOps);
		System.out.println("=========premain execute2 end========");
	}

	public static void main(String[] args) {
	}
}