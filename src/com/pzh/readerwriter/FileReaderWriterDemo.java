/**
* @Author pzh
* @Date 2019年9月15日 下午4:07:06
* @Description 
*/
package com.pzh.readerwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("e:/pzh/test/log4net.config");
		FileWriter fw = new FileWriter("e:/pzh/test/log.config");
		char[] buf = new char[4096];
		int reads = 0;
		while((reads = fr.read(buf)) > 0) {
			fw.write(buf, 0, reads);
//			fw.flush();//可以强制写盘，fw中有8的缓冲区 
		}
		fr.close();
		fw.close();
		System.out.println("=============FileReaderWriter copy file success=========");
	}

}
