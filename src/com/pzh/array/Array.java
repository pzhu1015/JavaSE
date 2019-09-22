/**
* @Author pzh
* @Date 2019��9��15�� ����10:12:11
* @Description 
*/
package com.pzh.array;

//������̬����
/*
������һ������������ݵ�һ�����ݽṹ����Ҫ����javaʵ��һ���򵥵��������ɾ�Ĳ�Ĳ�����

������Ҫ˵�����Ƕ�̬�����ʵ���ǵ���������Ԫ�غ�sizeֵ�������鳤��ʱ���Զ����䵽ԭ�����鳤�ȵ�2����java�е�������1.5���������䷽�����½�һ������Ϊ2���������飬��ԭ��������ֵ���Ƶ��������У�ԭ����������ָ����������飻ͬ��ɾ��Ԫ�غ�sizeֵ�������鳤�ȵ�һ��ʱ���Զ����䵽ԭ�����鳤�ȵ�һ�롣ƽ��ÿ��addLast����ִ��2��resize,ƽ̯����o(1),����о�̯���Ӷȡ�
��������������𵴸��Ӷȵ����⣬�����ԭʼ�����еļ�����10��Ԫ�ص����һ��Ԫ�غ�����Ϊ����Ϊ20�����飬����ɾ��һ������ʱ���ֻ�����������Ϊ10�����飬ÿ����һ�ζ�̬���²������Ӷ�Ϊo(n)�����ԸĽ�����Ϊ����ɾ��Ԫ��ʱ��Ҫ�ż��������������������õ�Ԫ�ؼ��ٵ�ԭ�������1/4ʱ���ٽ�������ٵ�ԭ����һ�롣
*/
/**
 * ��:o(n)
 * ɾ:o(n)
 * (����ɾ���ֻ�����һ��Ԫ�ز�����Ȼ��o(n)������Ϊʹ����resize.
 * ���ǲ�����ÿ�ζ�����resize��ƽ��ÿ��addLast����ִ��2��resize,ƽ̯����o(1),����о�̯���Ӷȡ�
 * ������Ԫ������ʱ�����һ��Ԫ�أ���ɾ�����Ԫ�أ������һ��Ԫ�ء����������ݻ������������������ֽи��Ӷ��𵴡�
 * ����ԭ�򣺵�ɾ�����һ��Ԫ��ʱ�����ż�������������
 * �����������ɾ�����һ��Ԫ��ʱ��Ҫ�ż����������������ȼ���һ���ֺ��ٽ�������)
 * ��:��֪����o(1),δ֪����o(n)
 * ��:��֪����o(1),δ֪����o(n)
 */
public final class Array<E> {// ʹ�÷���
	private E[] data;
	private int size;// ����

	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);// ����Ĭ��ֵ
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// ������Ԫ�ص����һ��Ԫ�����
	public void addLast(E e) {
		add(size, e);
	}

	// ���һ�����Ԫ��
	public void addFirst(E e) {
		add(0, e);
	}

	// ��������ָ����Ԫ�����Ԫ��
	public void add(int index, E e) {
		// ��������������
		if (size == data.length)
			resize(2 * data.length);
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add failed");
		}

		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		data[index] = e;
		size++;
	}

	// ��ȡindex����λ��
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("add failed");
		return data[index];
	}

	// �޸�
	void set(int index, E e) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("add failed");
		data[index] = e;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
		res.append("[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1)
				res.append(",");
		}
		res.append("]");
		return res.toString();
	}

	// ��ѯ�Ƿ��и�Ԫ��
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return true;
		}
		return false;
	}

	// ��������ҵ�Ԫ��e���ڵ�����
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return i;
		}
		return -1;
	}

	// ��������ɾ��Ԫ�ز��ҷ���
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Error");
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++)
			data[i - 1] = data[i];
		size--;

		// �ڴ˴�ʹ�÷��𵲴���, 
		if (size == data.length / 4 && data.length / 2 != 0)
			resize(data.length / 2);
		return ret;
	}

	// ɾ����Ҫɾ����Ԫ��
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1)
			remove(index);
	}

	// ���ݺ���
	private void resize(int newCapacity) {
		E[] newdata = (E[]) new Object[newCapacity];
		for (int i = 0; i < data.length; i++) {
			newdata[i] = data[i];
		}
		data = newdata;
	}

	public E getLast() {
		return get(size - 1);
	}

	public E getFirst() {
		return get(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public E removeFirst() {
		return remove(0);
	}
}