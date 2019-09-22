/**
* @Author pzh
* @Date 2019年9月15日 下午2:00:39
* @Description 
*/
package com.pzh.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOStreamDemo {

	public static void main(String[] args) throws IOException {

		long t1 = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("e:/pzh/test/hadoop-2.8.5.tar.gz");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("e:/pzh/test/hadoop-2.8.5.tar-01.gz");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int reads = 0;
		byte[] buf = new byte[409600]; 
		while((reads = bis.read(buf)) != -1) {
			bos.write(buf, 0, reads);
		}
		bis.close();
		bos.close();
		long t2 = System.currentTimeMillis();
		System.out.println("===========copy file finished cost: " + (t2 - t1));
	}

}
