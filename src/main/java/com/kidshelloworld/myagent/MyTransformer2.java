package com.kidshelloworld.myagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class MyTransformer2 implements ClassFileTransformer {
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println("transform class name: " + className + ", classloader: " + loader.toString());
//		className = className.replace("/", ".");
//		if (className.equals("com.kidshelloworld.myagent.Person2")) {
//			try {
//				CtClass ctclass = ClassPool.getDefault().get(className);
//				CtMethod helloM = CtNewMethod.make(
//						"public void hello2(String name){ System.out.println(\"hello \"+name);}", ctclass);
//				ctclass.addMethod(helloM);
//				System.out.println("add method hello to class: " + className);
//				return ctclass.toBytecode();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		return null;
	}
}
