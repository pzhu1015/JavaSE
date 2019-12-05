/**
* @Author pzh
* @Date 2019年10月20日 上午11:55:32
* @Description 
*/
package com.pzh.tree.huffmancode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "can you can a can as a can canner can a can.";

		byte[] bytes = msg.getBytes();
		// 创建赫夫曼编码
		Map<Byte, String> huffCodes = new HashMap<>();
		byte[] zipBytes = huffmanZip(bytes, huffCodes);
		System.out.println("old length: " + bytes.length + ", new lenght: " + zipBytes.length);
		byte[] unZipByte = huffmanUnZip(zipBytes, huffCodes);
	}

	private static byte[] huffmanUnZip(byte[] zipBytes, Map<Byte, String> huffCodes) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i< zipBytes.length; i++) {
			String str = byteToBitStr((i < zipBytes.length - 1), zipBytes[i]);
			sb.append(str);
		}
		System.out.println(sb);
		return null;
	}

	private static String byteToBitStr(boolean flag, byte b) {
		int tmp = b;
		if (flag) {
			tmp |= 256;
		}
		String str = Integer.toBinaryString(tmp);
		if (flag) {

			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	/**
	 * 进行赫夫曼编码压缩的方法
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes, Map<Byte, String> huffCodes) {

		// 先统计每一个byte出现的次数，并放入一个集合中
		List<Node> nodes = getNodes(bytes);
		System.out.println(nodes);
		// 创建一颗赫夫曼树
		Node tree = createHuffmanTree(nodes);
		System.out.println(tree);
		// 创建一个赫夫曼编码表
		huffCodes = getCodes(tree);
		System.out.println(huffCodes);
		// 编码
		byte[] zipBytes = zip(bytes, huffCodes);
		return zipBytes;
	}

	/**
	 * 对数据编码
	 * @param bytes
	 * @param huffCodes
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(huffCodes.get(b));
		}
		System.out.println(sb);
		int length = 0;
		if (sb.length() % 8 == 0) {
			length = sb.length() / 8;
		} else {
			length = sb.length() / 8 + 1;
		}
		byte[] zipBytes = new byte[length];

		for (int i = 0; i < sb.length(); i += 8) {
			String str;
			if (i + 8 > sb.length()) {
				str = sb.substring(i);
			} else {
				str = sb.substring(i, i + 8);
			}
			zipBytes[i / 8] = (byte) Integer.parseInt(str, 2);
//			System.out.println(zipBytes[i / 8]);
		}

		return zipBytes;
	}

	/**
	 * 根据赫夫曼树获取赫夫曼编码
	 * @param tree
	 * @return
	 */
	private static Map<Byte, String> getCodes(Node tree) {
		if (tree == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Map<Byte, String> huffCodes = new HashMap<>();
		getCodes(tree.getLeft(), "0", sb, huffCodes);
		getCodes(tree.getRight(), "1", sb, huffCodes);
		return huffCodes;
	}

	private static void getCodes(Node node, String code, StringBuilder sb, Map<Byte, String> huffCodes) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if (node.getData() == null) {
			getCodes(node.getLeft(), "0", sb2, huffCodes);
			getCodes(node.getRight(), "1", sb2, huffCodes);
		} else {
			huffCodes.put(node.getData(), sb2.toString());
		}
	}

	/**
	 * 创建赫夫曼树
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {

		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			Node parent = new Node(null, left.getWeight() + right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	private static List<Node> getNodes(byte[] bytes) {

		List<Node> nodes = new ArrayList<>();

		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}

		return nodes;
	}

}
