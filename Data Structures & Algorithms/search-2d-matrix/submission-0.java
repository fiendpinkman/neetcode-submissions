class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, matrix.length);
    }

    public boolean binarySearch(int[][] matrix, int target, int matrixLength) {
        if (matrixLength == 0) {
            return false;
        }
        int[] currentRow = matrix[matrixLength - 1];
        int start = 0;
        int end = currentRow.length-1;
        while (start<=end) {
            int mid = start + (end - start)/2;
            if (currentRow[mid]==target) {
                return true;
            } else if (currentRow[mid]<target) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return binarySearch(matrix,target,matrixLength-1);
    }
}
