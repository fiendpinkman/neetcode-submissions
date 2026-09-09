class Solution {
    char[][] grid;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[rowLength][colLength];
        int numIsLands = 0;;
        for (int i=0; i<rowLength; i++) {
            for (int j=0; j<colLength; j++) {
                if (grid[i][j] == '1' && visited[i][j] != true) {
                    System.out.println("Found 1 at row:" + i + " col:" + j);
                    dfs(i, j);
                    numIsLands++;
                }
            }
        }
        
        return numIsLands;
    }

    public void dfs(int row, int col) {
        if (row<0 || row >= grid.length) return;
        if (col<0 || col >= grid[0].length) return;
        if (visited[row][col] == true) return;
        if (grid[row][col] != '1') return;
        
        visited[row][col] = true;

        dfs(row-1, col);
        dfs(row+1, col);
        dfs(row, col-1);
        dfs(row, col+1);
    }
}
