/**
* @Author pzh
* @Date 2019年9月15日 下午4:18:14
* @Description 
*/
package com.pzh.readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("e:/pzh/test/log.config");
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("e:/pzh/test/log1.config");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
			bw.write(line);
			bw.newLine();
		}
		br.close();
		bw.close();
	}

}
