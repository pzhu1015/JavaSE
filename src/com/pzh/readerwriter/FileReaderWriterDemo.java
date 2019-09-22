/**
* @Author pzh
* @Date 2019��9��15�� ����4:07:06
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
//			fw.flush();//����ǿ��д�̣�fw����8�Ļ����� 
		}
		fr.close();
		fw.close();
		System.out.println("=============FileReaderWriter copy file success=========");
	}

}
