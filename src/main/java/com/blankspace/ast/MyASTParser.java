package com.blankspace.ast;

import java.util.Map;

import org.eclipse.jdt.core.dom.ASTNode;

import com.blankspace.ast.node.MyASTNode;
import com.blankspace.ast.node.MyMethodNode;

public class MyASTParser {

	public static String parseDot(MyMethodNode methodNode) {
		StringBuilder content = new StringBuilder();
		content.append("digraph \"DirectedGraph\" {\n")
				.append("graph [label = \"")
				.append(methodNode.getMethodNode().getName())
				.append("\", labelloc=t, concentrate = true];\n");
		for (MyASTNode myASTNode : methodNode.getNodeList()) {
			ASTNode astNode = myASTNode.getAstNode();
			int nodeHashcode = astNode.hashCode();
			int nodeType = astNode.getNodeType();
			content.append("\"")
					.append(nodeHashcode)
					.append("\" [ label=\"")
					.append(myASTNode.getLabel())
					.append("\" type=")
					.append(nodeType)
					.append(" startLineNumber=")
					.append(myASTNode.getStartLineNum())
					.append(" endLineNumber=")
					.append(myASTNode.getEndLineNum())
					.append(" ]\n");
		}
		for (Map.Entry<Integer, Integer> entry: methodNode.getpHash2cHashMap().entrySet()) {
			content.append("\"")
					.append(entry.getKey())
					.append("\" -> \"")
					.append(entry.getValue())
					.append("\"\n");
		}
		content.append("}\n");
		return content.toString();
	}

}
