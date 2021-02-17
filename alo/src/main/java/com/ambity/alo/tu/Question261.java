package com.ambity.alo.tu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
 * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 * 深度优先遍历看是否能回到当前起点,树的条件是没有循环，且深度优先可以遍历到所有的节点
 */
public class Question261 {
    public boolean validTreeDFS(int n, int[][] edges) {

        int[] isVisit = new int[n];
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        // 深度优先搜索按栈实现
        Stack<Integer> stack = new Stack<>();
        // 头节点入栈
        stack.push(0);

        while (!stack.isEmpty()){
            int pop = stack.pop();
            isVisit[pop] = 1;
            for (int j=0;j<n;j++){
                if (graph[pop][j]==1){
                    // 判断当前节点是否访问过，如果是则返回false
                    if (isVisit[j]==1){
                        return false;
                    }
                    // 更新图
                    isVisit[j]=1;
                    graph[j][pop] = 0;
                    graph[pop][j] = 0;
                    stack.push(j);
                }
            }
        }
        // 判断是否有单连通节点
        for (int dot: isVisit){
            if (dot==0){
                return false;
            }
        }

        //构建邻接矩阵
      return true;
    }
    public boolean validTreeBfs(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        //进行BFS
        Queue<Integer> queue = new LinkedList<>();
        //从第一个节点开始搜索，这样就不会漏掉无边图的情况
        queue.add(0);
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;
            //获取邻接点
            for (int i = 0; i < n; i++) {
                //查看当前节点的邻接点
                if (graph[cur][i] == 1) {
                    //如果访问过，则返回false
                    if (visited[i])
                        return false;

                    //标记邻接点，入队列
                    visited[i] = true;
                    //涂黑访问过的节点
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    queue.add(i);
                }
            }
        }

        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
