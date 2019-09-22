/**
* @Author pzh
* @Date 2019��9��14�� ����8:20:43
* @Description 
*/
package com.pzh.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("e:\\pzh\\test");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.exists());
		System.out.println(file.length());
		System.out.println(file.delete());
		
		File myFile = new File("e:/pzh/test/zhangsan");
		System.out.println(myFile.mkdir());
		
		File myFile2 = new File("e:/pzh/test/zhangsan/pzh.txt");
		System.out.println(myFile2.createNewFile());
		
		//�鿴��ǰĿ¼�µ�����Ŀ¼���ļ�
		String[] files = file.list();
		for (String f : files) {
			System.out.println(f);
		}
		
		System.out.println("===================================");
		
		//�鿴��ǰĿ¼��ָ����׺���ļ�
		files = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".txt");
			}
			
		});
		for (String f : files) {
			System.out.println(f);
		}
		
		System.out.println("===================================");
		
		//�鿴��Ŀ¼�µ������ļ�File����
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			System.out.println(f.getName() + (f.isDirectory()?"\\":"") + "\t" + f.length());
		}
		System.out.println("===================================");
		
		//�鿴��ǰĿ¼�µ����к�׺Ϊ".txt"���ļ�����
		listFiles = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".txt");
			}
			
		});
		
		for (File f : listFiles) {
			System.out.println(f.getName());
		}
		System.out.println("===================================");
		
		listFiles = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				
				return pathname.getName().endsWith(".txt");
			}
			
		});
		
		for (File f : listFiles) {
			System.out.println(f.getName());
		}
	}

}
