package com.blankspace.ast.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MyMethodNode {

	private MethodDeclaration methodNode;

	private List<MyASTNode> nodeList;

	private Map<Integer, Integer> pHash2cHashMap;

	public MyMethodNode() {
		this.methodNode = null;
		this.nodeList = new ArrayList<>();
		this.pHash2cHashMap = new HashMap<>();
	}

	public MyMethodNode(MethodDeclaration methodNode, List<MyASTNode> nodeList, Map<Integer, Integer> pHash2cHashMap) {
		this.methodNode = methodNode;
		this.nodeList = nodeList;
		this.pHash2cHashMap = pHash2cHashMap;
	}

	public MethodDeclaration getMethodNode() {
		return this.methodNode;
	}

	public void setMethodNode(MethodDeclaration methodNode) {
		this.methodNode = methodNode;
	}

	public List<MyASTNode> getNodeList() {
		return this.nodeList;
	}

	public void setNodeList(List<MyASTNode> nodeList) {
		this.nodeList = nodeList;
	}

	public Map<Integer, Integer> getpHash2cHashMap() {
		return this.pHash2cHashMap;
	}

	public void putPHashAndCHash(int parentHashCode, int childHashCode) {
		this.pHash2cHashMap.put(parentHashCode, childHashCode);
	}

	public void addMyASTNode(MyASTNode node) {
		this.nodeList.add(node);
	}

}
