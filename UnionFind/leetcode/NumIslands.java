package UnionFind.leetcode;

/**
 * @autor yud1
 * @date 2022/11/19 21:41
 */
public class NumIslands {


    //行数
    public int N;

    //列数
    public int M;


    public int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    inject(grid, i, j);
                }
            }
        }
        return res;
    }


    public void inject(char[][] grid, int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        inject(grid, i + 1, j);
        inject(grid, i - 1, j);
        inject(grid, i, j + 1);
        inject(grid, i, j - 1);
    }
}
