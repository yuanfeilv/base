//package com.ambity.alo.dongtaiguihua;
//
///**
// * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
// * 输入：matrix = [["1","0","1","0","0"],
// * ["1","0","1","1","1"],
// * ["1","1","1","1","1"],
// * ["1","0","0","1","0"]]
// * 输出：6
// * 解释：最大矩形如上图所示。
// * 示例 2：
// *
// * 输入：matrix = []
// * 输出：0
// * 示例 3：
// *
// * 输入：matrix = [["0"]]
// * 输出：0
// * 示例 4：
// *
// * 输入：matrix = [["1"]]
// * 输出：1
// *  dp 是以当前节点为右下节点的 最大举行的 长和宽
// */
//public class Question85 {
//    public int maximalRectangle(char[][] matrix) {
//        int max = 0;
//        int[][] dp_x = new int[matrix.length][matrix[0].length];
//        int[][] dp_y = new int[matrix.length][matrix[0].length];
//        // 初始化
//        if (matrix.length==0 || matrix[0].length==0){
//            return 0;
//        }
//        dp_x[0][0] = matrix[0][0];
//        dp_y[0][0] = matrix[0][0];
//        for (int i = 1;i<matrix[0].length;i++){
//            if (matrix[0][i] == 0){
//                dp_x[0][i] = 0;
//                dp_y[0][i] = 0;
//            }else {
//                dp_x[0][i] = 1+ dp_x[0][i-1];
//                dp_y[0][i] = 1;
//            }
//            max = Math.max(max,dp_x[0][i]*dp_y[0][i]);
//        }
//        if (matrix[0].length == 1){
//            return max;
//        }
//        for (int i = 1;i<matrix.length;i++){
//            if (matrix[i][0] == 0){
//                dp_x[i][0] = 0;
//                dp_y[i][0] = 0;
//            }else {
//                dp_x[i][0] = 1;
//                dp_y[i][0] = 1+dp_y[i-1][0];
//            }
//            max = Math.max(max,dp_x[i][0]*dp_y[i][0]);
//        }
//        if (matrix.length == 1){
//            return max;
//        }
//        for (int i = 1;i<matrix.length;i++){
//            for (int j =1;j<matrix[0].length;j++){
//                if (matrix[i][j] == 0){
//                    dp_x[i][j] = 0;
//                    dp_y[i][j] = 0;
//                }else {
//                    dp_x[i][j] = Math.min(1+Math.min(dp_x[i][j-1],dp_x[i-1][j-1]),)
//                }
//            }
//        }
//        return max;
//    }
//}
