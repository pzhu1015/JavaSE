/**
* @Author pzh
* @Date 2019年9月15日 下午4:40:59
* @Description 
*/
package com.pzh.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Student st = new Student("pzh", 30);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/pzh/test/student.txt"));
		oos.writeObject(st);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/pzh/test/student.txt"));
		st = (Student)ois.readObject();
		System.out.println(st);
		ois.close();
	}

}

class Student implements Serializable{
	private static final long serialVersionUID = 1176456474386340370L;

	private String name;
	private int age;
//	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
