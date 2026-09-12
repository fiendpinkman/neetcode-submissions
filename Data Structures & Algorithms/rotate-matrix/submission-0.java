class Solution {
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int endPointer = matrix.length-1-i;
                if (i<endPointer) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[endPointer][j];
                    matrix[endPointer][j] = temp;
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=i+1; j<matrix[0].length; j++) {
                int endPointer = matrix.length-1-i;
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }

    }
}
