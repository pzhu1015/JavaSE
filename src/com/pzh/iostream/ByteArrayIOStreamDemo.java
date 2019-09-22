/**
* @Author pzh
* @Date 2019年9月15日 上午12:31:19
* @Description 
*/
package com.pzh.iostream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayIOStreamDemo {

	public static void main(String[] args) throws IOException {
		
		String str =  "Hello World!!!";
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int reads = -1;
		byte[] buf = new byte[4096];
		while((reads = bis.read(buf)) > 0) {
			bos.write(buf, 0, reads);
		}
		bos.write(", write success".getBytes());
		System.out.println(bos.toString());
		
		FileOutputStream fos = new FileOutputStream("e:/pzh/test/byteArrayFile.txt", true);
		
		bos.writeTo(fos);
		fos.close();
	}

}
