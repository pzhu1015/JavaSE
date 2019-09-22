/**
* @Author pzh
* @Date 2019年9月15日 上午12:09:56
* @Description 
*/
package com.pzh.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamDemo {

	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("e:/pzh/test/hadoop-2.8.5.tar.gz");

		FileOutputStream fos = new FileOutputStream("e:/pzh/test/hadoop-2.8.5.tar-01.gz");
		
		int reads = -1;
		byte[] buf = new byte[409600];
		while((reads = fis.read(buf)) > 0) {
			fos.write(buf, 0, reads);
		}
		fos.close();
		fis.close();
		long t2 = System.currentTimeMillis();
		System.out.println("===========copy file finished cost: " + (t2 - t1));
	}

}
