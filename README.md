# JDT构建AST

操作流程：
1. 创建`sources`目录与`targets`目录。
2. 将目标Java源文件放入`sources`目录下。
3. Maven下载依赖。
4. Maven编译项目。
5. 运行`com.blankspace.ast.Main.java`。
6. 查看`targets`目录下的输出。
7. 用工具可视化.dot文件：
    - [http://www.webgraphviz.com](http://www.webgraphviz.com)
    - [https://dreampuf.github.io/GraphvizOnline/](https://dreampuf.github.io/GraphvizOnline/)
    - [http://graphviz.it](http://graphviz.it)
