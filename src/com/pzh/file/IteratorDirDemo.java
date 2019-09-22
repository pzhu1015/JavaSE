/**
* @Author pzh
* @Date 2019年9月14日 下午11:35:59
* @Description 
*/
package com.pzh.file;

import java.io.File;
import java.io.FileFilter;

public class IteratorDirDemo {

	public static void main(String[] args) {
		
		iteratorDir(new File("e:/pzh/test"), "");
	}

	public static void iteratorDir(File file, String tab) {
		String subTab = tab + "\t";
		if (file != null) {
			if (file.isFile() || file.listFiles().length == 0) {
				return;
			}else {
				File[] listDirs = file.listFiles(new FileFilter() {

					@Override
					public boolean accept(File pathname) {
						
						return pathname.isDirectory();
					}
					
				});
				for (File d : listDirs) {
					System.out.println(tab + d.getName() + "\\");
					
					iteratorDir(d, subTab);
				}
				File[] listFiles = file.listFiles(new FileFilter() {

					@Override
					public boolean accept(File pathname) {
						
						return pathname.isFile();
					}
					
				});
				
				for (File f : listFiles) {
					System.out.println(tab + "|" + f.getName());
				}
			}
		}
	}
}
