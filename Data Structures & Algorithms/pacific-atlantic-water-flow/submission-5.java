class Solution {
    int[][] heights; 
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rowLength;
    int colLength; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rowLength = heights.length;
        if (rowLength == 0) return new ArrayList<>();

        colLength = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] atlantic = new boolean[rowLength][colLength];

        for (int c=0; c<colLength; c++) {
            dfs(0, c, pacific);
            dfs(rowLength-1, c, atlantic);
        }

        for (int r=0; r<rowLength; r++) {
            dfs(r, 0, pacific);
            dfs(r, colLength-1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<rowLength; i++) {
            for (int j=0; j<colLength; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int[] direction: directions) {
            int nr = r + direction[0], nc = c + direction[1];
            if (nr >= 0 && nr < rowLength && 
                nc >= 0 && nc < colLength && 
                !ocean[nr][nc] && 
                heights[r][c] <= heights[nr][nc]) {
                dfs(nr, nc, ocean);
            }
        }
    }
}
