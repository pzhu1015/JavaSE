/**
* @Author pzh
* @Date 2019年9月15日 下午2:37:47
* @Description 
*/
package com.pzh.iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOStreamDemo {

	public static void main(String[] args) throws IOException {

		String name = "zhangsan";
		int age = 10;
		boolean flag = true;
		char sex = '男';
		double money = 100.56;
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("e:/pzh/test/dataoutput.txt"));
		dos.writeUTF(name);
		dos.writeInt(age);
		dos.writeBoolean(flag);
		dos.writeChar(sex);
		dos.writeDouble(money);
		
		System.out.println("data output stream write success");
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("e:/pzh/test/dataoutput.txt"));
		System.out.println("name = " + dis.readUTF());
		System.out.println("age = " + dis.readInt());
		System.out.println("flag = " + dis.readBoolean());
		System.out.println("sex = " + dis.readChar());
		System.out.println("money = " + dis.readDouble());
		
		System.out.println("data input stream read success");
		 dis.close();
	}

}
