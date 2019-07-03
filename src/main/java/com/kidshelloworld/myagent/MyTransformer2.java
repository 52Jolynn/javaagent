package com.kidshelloworld.myagent;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

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
		className = className.replace("/", ".");
		if (className.equals("com.kidshelloworld.myagent.Person2")) {
			try {
				ClassPool pool = ClassPool.getDefault();
				pool.insertClassPath(new ClassClassPath(Person2.class));
				CtClass ctclass = pool.get(className);
				CtMethod ctMethod = ctclass.getDeclaredMethod("hello2");
				ctMethod.setBody("System.out.println(\"hello person2\");");
				System.out.println("add method hello to class: " + className);
				byte[] data = ctclass.toBytecode();
				ctclass.defrost();
				return data;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return classfileBuffer;
	}
}
