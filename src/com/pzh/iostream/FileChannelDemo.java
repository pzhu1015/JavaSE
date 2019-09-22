/**
* @Author pzh
* @Date 2019年9月15日 下午3:00:13
* @Description 
*/
package com.pzh.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public static void main(String[] args) throws IOException {

		long t1 = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("e:/pzh/test/hadoop-2.8.5.tar.gz");

		FileOutputStream fos = new FileOutputStream("e:/pzh/test/hadoop-2.8.5.tar-01.gz");
		
		FileChannel fic = fis.getChannel();
		FileChannel foc = fos.getChannel();
		
		foc.transferFrom(fic, 0, fic.size());
		
		fis.close();
		fos.close();
		fic.close();
		foc.close();
		long t2 = System.currentTimeMillis();
		System.out.println("===========copy file finished cost: " + (t2 - t1));
	}

}
