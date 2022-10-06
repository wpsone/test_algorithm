package M11;

//934. 最短的桥
public class ShortestBridge934 {
    public int shortestBridge(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid,i,j);
                    while (!bfs(grid)) {
                        ret++;
                    }
                    return ret;
                }
            }
        }
        return -1;
    }

    private boolean bfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==2) {
                    if (color(grid, i - 1, j) || color(grid, i + 1, j) || color(grid, i, j - 1) || color(grid, i, j + 1)) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==3) {
                    grid[i][j]=2;
                }
            }
        }
        return false;
    }

    private boolean color(int[][] grid,int i,int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid.length) {
            return false;
        }
        if (grid[i][j]==1) {
            return true;
        }
        if (grid[i][j]==0) {
            grid[i][j]=3;
        }
        return false;
    }

    private void dfs(int[][] grid,int i,int j    ){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
