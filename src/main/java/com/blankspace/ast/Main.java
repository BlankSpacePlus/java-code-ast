package com.blankspace.ast;

import java.io.File;
import java.util.List;

import com.blankspace.ast.node.MyMethodNode;
import com.blankspace.ast.util.ASTFileUtil;


public class Main {

    public static void main(String[] args) {
        String sourcePath = "sources/";
        String targetPath = "targets/";
        File directory = new File(sourcePath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        ASTGenerator astGenerator = new ASTGenerator(file);
                        List<MyMethodNode> methodNodeList = astGenerator.getMethodNodeList();
                        for (MyMethodNode methodNode : methodNodeList) {
                            String dotContent = MyASTParser.parseDot(methodNode);
                            ASTFileUtil.writeFile(targetPath + file.getName() + "_" + methodNode.getMethodNode().getName() + ".dot", dotContent);
                        }
                        System.out.println(file.getName() + " Done.");
                    }
                }
            }
        } else {
            System.out.println("Not a Dictionary!");
        }
    }

}
