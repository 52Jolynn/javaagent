package com.kidshelloworld.myagent;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class Myagent {
	public static void premain(String agentOps, Instrumentation inst) {
		System.out.println("=========premain execute========");
		System.out.println("agentOps: " + agentOps);
		inst.addTransformer(new MyTransformer(), true);
		System.out.println("=========premain execute end========");

		Class[] classes = inst.getAllLoadedClasses();
		List<Class> candidates = new ArrayList<>();
		for (Class c : classes) {
			if (inst.isModifiableClass(c) && inst.isRetransformClassesSupported()) {
				candidates.add(c);
			}
		}
		System.out.println("There are " + candidates.size() + " classes");
		try {
			// if we have matching candidates, then
			// retransform those classes so that we
			// will get callback to transform.
			if (!candidates.isEmpty()) {
				Iterator it = candidates.iterator();
				while (it.hasNext()) {
					Class c = (Class) it.next();
					if (!c.getName().startsWith("javassist")) {
						System.out.println(" ========================> In Progress:" + c.getName());
						inst.retransformClasses(c);
					}
				}
			} else {
				System.out.println("candidates.isEmpty()");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void premain(String agentOps) {
		System.out.println("====premain execute2====");
		System.out.println("agentOps: " + agentOps);
		System.out.println("=========premain execute2 end========");
	}

	public static void agentmain(String agentmain, Instrumentation inst) {
		System.out.println("=========premain execute========");
		System.out.println("agentArgs: " + agentmain);
		inst.addTransformer(new MyTransformer(), true);
		System.out.println("=========premain execute end========");
	}

	public static void agentmain(String agentArgs) {
		System.out.println("====agentmain execute2====");
		System.out.println("agentArgs: " + agentArgs);
		System.out.println("=========agentmain execute2 end========");
	}

	public static void main(String[] args) {
	}
}