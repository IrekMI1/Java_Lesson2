public class Solution {
    private int maxSize = 0;
    private int size = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
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

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        findPixel(image, sr, sc, currentColor, color);
        return image;
    }

    private void findPixel(int[][] image, int row, int col, int curColor, int color) {
        if (row < 0 || row >= image.length
                || col < 0 || col >= image[row].length
                || image[row][col] != curColor
                || color == curColor) {
            return;
        }
        image[row][col] = color;
        findPixel(image, row - 1, col, curColor, color);
        findPixel(image, row + 1, col, curColor, color);
        findPixel(image, row, col - 1, curColor, color);
        findPixel(image, row, col + 1, curColor, color);
    }
}
