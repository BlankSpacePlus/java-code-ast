package com.blankspace.ast.node;

import org.eclipse.jdt.core.dom.ASTNode;

public class MyASTNode {

    private ASTNode astNode;

    private int startLineNum;

    private int endLineNum;

    public MyASTNode() {
    }

    public MyASTNode(ASTNode astNode, int startLineNum, int endLineNum) {
        this.astNode = astNode;
        this.startLineNum = startLineNum;
        this.endLineNum = endLineNum;
    }

    public ASTNode getAstNode() {
        return this.astNode;
    }

    public void setAstNode(ASTNode astNode) {
        this.astNode = astNode;
    }

    public int getStartLineNum() {
        return this.startLineNum;
    }

    public void setStartLineNum(int startLineNum) {
        this.startLineNum = startLineNum;
    }

    public int getEndLineNum() {
        return this.endLineNum;
    }

    public void setEndLineNum(int endLineNum) {
        this.endLineNum = endLineNum;
    }

    public String getLabel() {
        String nodeContent = this.astNode.toString().replace("\n", " ")
                .replace("\"", "\\\"")
                .replace("  ", " ");
        String nodeType = ASTNode.nodeClassForType(this.astNode.getNodeType()).getName()
                .replace("org.eclipse.jdt.core.dom.", "");
        StringBuilder label = new StringBuilder();
        label.append("(")
                .append(nodeContent)
                .append(",")
                .append(nodeType)
                .append(",")
                .append(this.startLineNum)
                .append(",")
                .append(this.endLineNum)
                .append(")");
        return label.toString();
    }

}
