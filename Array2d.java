
import java.util.Arrays;



public class Array2d {

    public static void printMatirx(int matrix[][],int  n ,int m ) {
        for(int i =0; i<n; i++) {
            for(int j =0; j<m;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void spiralMatrix(int matrix[][], int n, int m) {
        int startRow = 0 , endRow = n-1, startCol = 0 , endCol = m-1;

        while(startRow <= endRow && startCol <= endCol) {

            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j]+" ");
            }

            for(int i=startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol]+" ");
            }

            for(int j=endCol-1; j>= startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }

            for(int i=endRow-1; i>=startRow+1; i-- ) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println("");
    }

    public static int diagonalSum(int matrix[][]) {
        int sum =0;

        for(int i=0; i<matrix.length; i++) {
            sum += matrix[i][i];

            if( i != matrix.length-1-i) {
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;  
    }

    public static boolean searchInSortedMatrix(int matrix[][], int key ) {
          int row = 0, col = matrix[0].length-1;

          while( row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
               return true;
            } else if (key <matrix[row][col]) {
                col--;
            } else{
                row++;
            }
        }
        return false;
    }

    public static void transpose(int matrix[][]) {
        int transpose[][] = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length;i++) {
            for(int j=0; j<matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        printMatirx(transpose,transpose.length,transpose[0].length);
    }

    public static int[] findPeak2d(int matrix[][]) {
        int n = matrix.length , m = matrix[0].length;
        int low = 0 ,  high = m-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int maxRow = findMaxIdx(matrix, n, m, mid);
            int left = mid-1>=0 ? matrix[maxRow][mid-1] : -1;
            int right = mid+1 < m ? matrix[maxRow][mid+1] : -1;

            if(matrix[maxRow][mid]> left && matrix[maxRow][mid] > right) {
                return new int[]{maxRow, mid}; 
            }
            else if(matrix[maxRow][mid]< left) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};  
    }
    public static int findMaxIdx(int matrix[][], int n, int m, int col) {
        int maxValue = -1;
        int idx = -1;

        for(int i = 0; i<n; i++) {
            if(matrix[i][col] > maxValue) {
                maxValue = matrix[i][col];
                idx = i;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,15},{21,30,14},{7,16,32}};
        int n = matrix.length,m = matrix[0].length ;

    
        printMatirx(matrix, n, m);
        int peak[] = findPeak2d(matrix);
        System.out.println(Arrays.toString(peak));
    }
}
