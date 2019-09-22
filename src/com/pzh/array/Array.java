/**
* @Author pzh
* @Date 2019年9月15日 下午10:12:11
* @Description 
*/
package com.pzh.array;

//创建动态数组
/*
数组是一段连续存放数据的一种数据结构，主要是用java实现一个简单的数组的增删改查的操作。

其中需要说明的是动态数组的实现是当增加数组元素后，size值等于数组长度时，自动扩充到原来数组长度的2倍（java中的数组是1.5倍），扩充方法是新建一个长度为2倍的新数组，将原来的数组值复制到新数组中，原来的数组再指向这个新数组；同理当删除元素后，size值等于数组长度的一半时，自动扩充到原来数组长度的一半。平均每次addLast操作执行2次resize,平摊下来o(1),这个叫均摊复杂度。
但是这样会造成震荡复杂度的问题，即如果原始数组中的假如有10个元素当添加一个元素后扩充为容量为20的数组，当再删除一个数组时，又会缩减成容量为10的数组，每进行一次动态更新操作复杂度为o(n)。所以改进方法为，在删除元素时不要着急缩减容量，即可以设置当元素减少到原来数组的1/4时，再将数组减少到原来的一半。
*/
/**
 * 增:o(n)
 * 删:o(n)
 * (增和删如果只对最后一个元素操作依然是o(n)，是因为使用了resize.
 * 但是并不是每次都出发resize，平均每次addLast操作执行2次resize,平摊下来o(1),这个叫均摊复杂度。
 * 当数组元素已满时，添加一个元素，再删掉这个元素，再添加一个元素。。。数组容积不断扩充缩减，这种叫复杂度震荡。
 * 出现原因：当删除最后一个元素时过于着急减少数组容量
 * 解决方案：当删除最后一个元素时不要着急减少数组容量，等减少一部分后再进行缩减)
 * 改:已知索引o(1),未知索引o(n)
 * 查:已知索引o(1),未知索引o(n)
 */
public final class Array<E> {// 使用泛型
	private E[] data;
	private int size;// 长度

	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);// 设置默认值
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

	// 向所有元素的最后一个元素添加
	public void addLast(E e) {
		add(size, e);
	}

	// 向第一个添加元素
	public void addFirst(E e) {
		add(0, e);
	}

	// 向数组里指定的元素添加元素
	public void add(int index, E e) {
		// 符合条件，扩容
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

	// 获取index索引位置
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("add failed");
		return data[index];
	}

	// 修改
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

	// 查询是否有该元素
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return true;
		}
		return false;
	}

	// 获得所查找到元素e所在的索引
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return i;
		}
		return -1;
	}

	// 从数组中删除元素并且返回
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Error");
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++)
			data[i - 1] = data[i];
		size--;

		// 在此处使用防震挡处理, 
		if (size == data.length / 4 && data.length / 2 != 0)
			resize(data.length / 2);
		return ret;
	}

	// 删除需要删除的元素
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1)
			remove(index);
	}

	// 扩容函数
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