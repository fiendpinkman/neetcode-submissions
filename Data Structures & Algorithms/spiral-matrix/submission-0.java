class Solution {
    List<Integer> result = new ArrayList<>();
    int [][] matrix;
    boolean[][] visited;
    int row; 
    int col;
    int runningRow = 0;
    int runningCol = 0;
    int dir = 0;
    int[] dRow = {0, 1, 0, -1};
    int[] dCol = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        this.row = matrix.length; 
        this.col = matrix[0].length;
        this.matrix = matrix;
        this.visited = new boolean[row+1][col+1];
        dfs();
        return result;
    }

    public void dfs() {
        
        visited[runningRow][runningCol] = true;
        result.add(matrix[runningRow][runningCol]);

        if (result.size() == row*col) {
            return;
        }

        int nextRow = runningRow + dRow[dir];
        int nextCol = runningCol + dCol[dir];

        if (nextRow<0 || nextCol<0 || nextRow>=row || nextCol>=col || visited[nextRow][nextCol]) {
            dir = (1+dir)%4;
            nextRow = runningRow + dRow[dir];
            nextCol = runningCol + dCol[dir];
        }

        runningRow = nextRow;
        runningCol = nextCol;

        dfs();
    } 
}
