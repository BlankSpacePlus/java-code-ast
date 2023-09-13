package com.blankspace.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

public class NodeVisitor extends ASTVisitor {

	private List<ASTNode> nodeList = new ArrayList<>();

	@Override
	public void preVisit(ASTNode node) {
		this.nodeList.add(node);
	}

	public List<ASTNode> getASTNodes() {
		return this.nodeList;
	}

}
