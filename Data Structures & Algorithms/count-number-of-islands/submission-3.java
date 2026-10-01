class Solution {
    boolean[][] visited;
    int rowLength;
    int colLength;
    char[][] grid;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        if (rowLength == 0) {
            return 0;
        }
        colLength = grid[0].length;
        this.grid = grid;
        visited = new boolean[rowLength][colLength];

        int count = 0;
        for (int i=0; i<rowLength; i++) {
            for (int j=0; j<colLength; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }

    public void dfs(int row, int col) {

        if (col<0 || col>colLength-1) return;
        if (row<0 || row>rowLength-1) return;
        if (visited[row][col] == true) return;
        if (grid[row][col] != '1') return;
        
        visited[row][col] = true; 
        grid[row][col] = '0';

        dfs(row, col-1);
        dfs(row, col+1);
        dfs(row-1, col);
        dfs(row+1, col);
    }
}
