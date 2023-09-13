package com.blankspace.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodNodeVisitor extends ASTVisitor {

    private List<MethodDeclaration> methodNodeList;

    public MethodNodeVisitor() {
        this.methodNodeList = new ArrayList<>();
    }

    @Override
    public boolean visit(MethodDeclaration node) {
        this.methodNodeList.add(node);
        return true;
    }

    public List<MethodDeclaration> getMethodDeclarations() {
        return this.methodNodeList;
    }

}
