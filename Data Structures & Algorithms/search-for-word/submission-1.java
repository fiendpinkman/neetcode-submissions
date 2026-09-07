class Solution {

    char[][] board;
    char[] letters;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }
        int rowCount = board.length;
        int colCount = board[0].length;
        this.board = board;
        this.letters = word.toCharArray();

        // Find first letter and submit it to dsf
        for (int i=0; i<rowCount; i++) {
            for (int j =0; j<colCount; j++) {
                boolean flag = false;
                visited = new boolean[rowCount][colCount];
                if (this.board[i][j] == letters[0]) {
                    flag = dsf(i, j, 0);
                    if (flag == true) {
                        return true ;
                    }
                }
            }
        }
        return false;
    }

    public boolean dsf(int row, int col, int indexOfWord) {

        // base conditions
        if (indexOfWord==letters.length) return true;
        if (row>=board.length || row<0) return false;
        if (col>=board[0].length || col<0) return false;
        if (visited[row][col]==true) return false;
        if (board[row][col] != letters[indexOfWord]) return false;

        visited[row][col] = true;

        boolean top = dsf(row-1, col, indexOfWord+1);
        boolean bottom = dsf(row+1, col, indexOfWord+1);
        boolean right = dsf(row, col+1, indexOfWord+1);
        boolean left = dsf(row, col-1, indexOfWord+1);

        boolean res = top || bottom || right || left;

        if(res==false) {
            visited[row][col] = false;
        } 
        return res;

    }
}
