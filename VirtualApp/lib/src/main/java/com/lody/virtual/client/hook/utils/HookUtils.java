package com.lody.virtual.client.hook.utils;

import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.helper.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lody
 *
 */
public class HookUtils {

	public static String replaceFirstAppPkg(Object[] args) {
		if (args == null) {
			return null;
		}
		int index = ArrayUtils.indexOfFirst(args, String.class);
		if (index != -1) {
			String pkg = (String) args[index];
			args[index] = VirtualCore.get().getHostPkg();
			return pkg;
		}
		return null;
	}

	public static String replaceLastAppPkg(Object[] args) {
		int index = ArrayUtils.indexOfLast(args, String.class);
		if (index != -1) {
			String pkg = (String) args[index];
			args[index] = VirtualCore.get().getHostPkg();
			return pkg;
		}
		return null;
	}

	public static String replaceSequenceAppPkg(Object[] args, int sequence) {
		int index = ArrayUtils.indexOf(args, String.class, sequence);
		if (index != -1) {
			String pkg = (String) args[index];
			args[index] = VirtualCore.get().getHostPkg();
			return pkg;
		}
		return null;
	}

	public static Class<?>[] getAllInterface(Class clazz){
		ArrayList<Class<?>> classes = new ArrayList<>();
		getAllInterfaces(clazz,classes);
		Class<?>[] result=new Class[classes.size()];
		classes.toArray(result);
		return result;
	}


	public static void getAllInterfaces(Class clazz, ArrayList<Class<?>> interfaceCollection) {
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length != 0) {
			interfaceCollection.addAll(Arrays.asList(classes));
		}
		if (clazz.getSuperclass() != Object.class) {
			getAllInterfaces(clazz.getSuperclass(), interfaceCollection);
		}
	}


}
