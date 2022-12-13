public class Solution {
    private int maxSize = 0;
    private int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[i].length; j++) {
                 if(grid[i][j] == 1) {
                     dfs(i, j, grid);
                     if (size > maxSize) {
                         maxSize = size;
                     }
                     size = 0;
                 }
             }
         }
         return maxSize;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        size++;
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
