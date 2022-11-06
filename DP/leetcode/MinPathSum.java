package DP.leetcode;

/**
 * @autor yud1
 * @date 2022/11/6 10:09
 */
public class MinPathSum {

    //行数
    public int m;

    //列数
    public int n;

    public int minPathSum(int[][] grid) {
        m =  grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m ; i ++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < n ; i ++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    //递归会栈溢出
    public int minPathSum(int[][] grid, int i , int j){
        if (i == m-1 && j == n-1) {
            return grid[i][j];
        }else if(i == m-1){
            return grid[i][j] + minPathSum(grid,i,j+1);
        } else if (j== n-1) {
            return grid[i][j] + minPathSum(grid,i,j+1);
        }else {
            return Math.min(minPathSum(grid,i,j+1), minPathSum(grid,i,j+1)) + grid[i][j];
        }
    }
}
