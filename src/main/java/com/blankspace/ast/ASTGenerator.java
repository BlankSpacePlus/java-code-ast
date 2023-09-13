package com.blankspace.ast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import com.blankspace.ast.node.MyASTNode;
import com.blankspace.ast.node.MyMethodNode;
import com.blankspace.ast.util.ASTFileUtil;
import com.blankspace.ast.visitor.MethodNodeVisitor;
import com.blankspace.ast.visitor.NodeVisitor;

public class ASTGenerator {

    public List<MyMethodNode> methodNodeList = new ArrayList<>();

    public ASTGenerator(File file) {
        parseFile(file);
    }

    public List<MyMethodNode> getMethodNodeList() {
        return this.methodNodeList;
    }

    public void parse(String srcStr) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(srcStr.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        // 构建Java源代码文件的整个抽象语法树
        // CompilationUnit是AST的根节点，包含了整个源代码文件的结构和信息
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        // 通过MethodNodeVisitor遍历所有节点
        // https://stackoverflow.com/questions/10331641/how-to-use-visitor-for-an-ast-in-java
        MethodNodeVisitor methodNodeVisitor = new MethodNodeVisitor();
        cu.accept(methodNodeVisitor);
        for (MethodDeclaration method : methodNodeVisitor.getMethodDeclarations()) {
            MyMethodNode myMethodNode = new MyMethodNode();
            myMethodNode.setMethodNode(method);
            NodeVisitor nodeVisitor = new NodeVisitor();
            method.accept(nodeVisitor);
            List<ASTNode> astNodeList = nodeVisitor.getASTNodes();
            for (ASTNode node : astNodeList) {
                MyASTNode myNode = new MyASTNode(node,
                        cu.getLineNumber(node.getStartPosition()),
                        cu.getLineNumber(node.getStartPosition() + node.getLength()));
                myMethodNode.addMyASTNode(myNode);
                // 排除根节点
                if (!node.equals(method)) {
                    int pHashcode = node.getParent().hashCode();
                    int cHashcode = node.hashCode();
                    myMethodNode.putPHashAndCHash(pHashcode, cHashcode);
                }
            }
            this.methodNodeList.add(myMethodNode);
        }
    }

    public void parseFile(File file) {
        String absolutePath = file.getAbsolutePath();
        if (file.isFile()) {
            try {
                parse(ASTFileUtil.readFileToString(absolutePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not a File!");
        }
    }

}
