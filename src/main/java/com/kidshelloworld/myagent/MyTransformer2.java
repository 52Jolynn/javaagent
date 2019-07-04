package com.kidshelloworld.myagent;

import org.objectweb.asm.*;

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
				ClassReader cr = new ClassReader(Person2.class.getName());
				ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
				cr.accept(new ClassVisitor(Opcodes.ASM7, cw) {
					@Override
					public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
							String[] exceptions) {
						if ("hello2".equals(name)) {
							return super.visitMethod(Opcodes.ACC_PUBLIC, name, descriptor, signature, exceptions);
						}
						return super.visitMethod(access, name, descriptor, signature, exceptions);
					}
				}, ClassReader.SKIP_DEBUG);
				return cw.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return classfileBuffer;
	}
}
