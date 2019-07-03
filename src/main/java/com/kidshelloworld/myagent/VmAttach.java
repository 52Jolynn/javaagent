package com.kidshelloworld.myagent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @author huangtiande@rfchina.com
 * create_date: 2019-7-2
 */
public class VmAttach extends Thread {
	private final List<VirtualMachineDescriptor> listBefore;
	private final String jar;

	VmAttach(String attachJar, List<VirtualMachineDescriptor> vms) {
		listBefore = vms;
		jar = attachJar;
	}

	public void run() {
		VirtualMachine vm = null;
		List<VirtualMachineDescriptor> listAfter;
		try {
			int count = 0;
			while (true) {
				listAfter = VirtualMachine.list();
				for (VirtualMachineDescriptor vmd : listAfter) {
					if (!listBefore.contains(vmd)) {
						vm = VirtualMachine.attach(vmd);
						break;
					}
				}
				Thread.sleep(500);
				count++;
				if (null != vm || count >= 100) {
					break;
				}
			}
			if (vm != null) {
				vm.loadAgent(jar);
				vm.detach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new VmAttach("myagent-1.0.0-SNAPSHOT.jar", VirtualMachine.list()).start();
	}
}

