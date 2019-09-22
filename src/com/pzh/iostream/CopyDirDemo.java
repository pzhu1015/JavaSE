/**
* @Author pzh
* @Date 2019年9月15日 下午3:29:23
* @Description 
*/
package com.pzh.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirDemo {

	public static void main(String[] args) throws IOException {
		
		copyDir(new File("e:/pzh/test/input"), new File("e:/pzh/test/input2"));
		System.out.println("==========copy directory success===========");
	}

	public static void copyDir(File src, File dest) throws IOException {
		
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdirs();
			}
			File[] files = src.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					File destDir = new File(dest.getAbsolutePath() + "/" + file.getName());
					copyDir(file, destDir);
				}else {
					File destFile = new File(dest.getAbsolutePath() + "/" + file.getName());
					copyFile(file, destFile);
				}
			}
		}
	}
	
	public static void  copyFile(File src, File dest) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream(dest);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int reads = 0;
		byte[] buf = new byte[4096];
		while((reads = bis.read(buf)) > 0) {
			bos.write(buf, 0, reads);
		}
		bis.close();
		bos.close();
	}
}
