/**
* @Author pzh
* @Date 2019年9月14日 下午8:20:43
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
		
		//查看当前目录下的所有目录和文件
		String[] files = file.list();
		for (String f : files) {
			System.out.println(f);
		}
		
		System.out.println("===================================");
		
		//查看当前目录下指定后缀的文件
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
		
		//查看当目录下的所有文件File对象
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			System.out.println(f.getName() + (f.isDirectory()?"\\":"") + "\t" + f.length());
		}
		System.out.println("===================================");
		
		//查看当前目录下的所有后缀为".txt"的文件对象
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
