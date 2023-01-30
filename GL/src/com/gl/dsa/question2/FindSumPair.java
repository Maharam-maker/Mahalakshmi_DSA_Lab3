package com.gl.dsa.question2;

import java.util.HashSet;

public class FindSumPair {

	static class Node {

		int nodeData;
		Node leftNode, rightNode;
	};

	static Node NewNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	private void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, sum, set))
			System.out.print("Pairs do not exist" + "\n");
	}

	private boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.leftNode, sum, set))
			return true;

		int diff = sum - root.nodeData;
		if (set.contains(diff)) {
			System.out.println("Pair is found(" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else
			set.add(root.nodeData);
		return findPairUtil(root.rightNode, sum, set);
	}

	public static void main(String[] args) {

		Node root = null;
		FindSumPair findPS = new FindSumPair();
		root = findPS.insert(root, 40);
		root = findPS.insert(root, 20);
		root = findPS.insert(root, 60);
		root = findPS.insert(root, 10);
		root = findPS.insert(root, 30);
		root = findPS.insert(root, 50);
		root = findPS.insert(root, 70);

		int sum = 130;
		findPS.findPairWithGivenSum(root, sum);
		display(root);
	}

	private static void display(Node root) {
		if (root != null) {
			display(root.leftNode);
			System.out.println(root.nodeData + " ");
			display(root.rightNode);
		}
	}
}
