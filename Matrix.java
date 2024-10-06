import java.util.*;
public class Matrix {
    public static List<Integer> lucknumber(int[][] matrix ) {
        ArrayList<Integer> rowMin = new ArrayList<>();
        ArrayList<Integer> colMax = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i< row; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<col; j++) {
                min = Math.min(min,matrix[i][j]);
            }
            rowMin.add(min);
        }
        for(int j=0; j< col; j++) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<row; i++) {
                max = Math.max(max,matrix[i][j]);
            }
            colMax.add(max);
        }
       
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<colMax.size(); i++) {
            if(rowMin.contains(colMax.get(i))) {
                result.add(colMax.get(i));
                break;
            }
        }
        return result;

    }
    static int check = 0;
    public static void solverSudoku(char[][] board, int row, int col) {
        
        if(row == board.length) {
            check = 1;
            return;
        }
        int nr = 0;
        int nc = 0;
        if(col == board[0].length -1 ) {
            nc = 0;
            nr = row + 1; 
        }else{
            nr = row;
            nc = col + 1;
        }
        if(board[row][col] != '.') {
            solverSudoku(board,nr,nc);
            
        }else{
            
            for(int i=1; i<=9; i++) {
                char num =(char) ('0' + i);
                boolean isPresent = ispresent(board, row, col, num);
                if(!isPresent) {
                    board[row][col] = num;
                    solverSudoku(board,nr,nc);
                    if (check == 1) return;
                    board[row][col] = '.';
                }
            }
        }
    }
    
    public static boolean ispresent(char[][] board, int row, int col, char number) {
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == number) {
                return true;
            }
        }
        for(int j=0; j<board[0].length; j++) {
            if(board[row][j] == number) {
                return true;
            }
        }
        int newRow = 3 * (row/3) ;
        int newCol = 3 * (col/3);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[newRow + i][newCol + j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void display(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]  + " , ");
            }
            System.out.println();
        }
    }
    public static long maxPoints(int[][] points) {
        long currMax = Integer.MIN_VALUE;
        long maxPoints = 0;
        int prevCol = 0;
        for(int i=0; i<points[0].length; i++) {
            if(currMax < points[0][i]) {
                prevCol = i;
                currMax = points[0][i];
            }
        }
        maxPoints = currMax;
        for(int i=1; i<points.length; i++) {
            int col = 0;
            for(int j=0; j<points[i].length; j++) {
                long sum = currMax;
                sum = sum + points[i][j] - Math.abs(prevCol - j);
                if(maxPoints < sum) {
                    maxPoints = sum;
                    col = j;
                }

            }
            currMax = maxPoints;
            prevCol = col;
        }


        return maxPoints;

    }
    public static int rowSearch(int[][] matrix, int target) {
        int lrow = 0;
        int last = matrix[0].length -1;
        int hrow = matrix.length;
        int mid = 0;
        while(lrow <= hrow) {
            mid =  lrow + (hrow - lrow)/2;
            if(matrix[mid][last] > target) {
                hrow = mid - 1 ;
            }else if(matrix[mid][last] < target) {
                lrow = mid + 1;
            } else {
                lrow = mid; 
                break;
            }
        }
        return lrow;
    }
    public static boolean colSearch(int[] col, int target) {
        int low = 0;
        int high = col.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(col[mid] == target) return true;
            else if(col[mid] > target) high = mid - 1;
            else low = mid + 1; 
        }
        return false;
    }
    public static boolean searching(int[][] matrix, int target) {
        if(matrix.length == 1) {
            return colSearch(matrix[0], target);
        }
        int row = rowSearch(matrix, target);
        return colSearch(matrix[row], target);
    }
    
    public static void zeros(int[][] matrix) {
        List<int[]> hash = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    hash.add(new int[]{i,j});
                }
            }
        }
        for(int i=0; i<hash.size(); i++) {
            int row = hash.get(i)[0];
            int col  = hash.get(i)[1];
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[row][j] != 0) 
                matrix[row][j] = 0;
            }
            for(int idx = 0; idx<matrix.length; idx++) {
                if(matrix[idx][col] != 0) matrix[idx][col] = 0;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if((i>=0 && i == grid1.length )||  (j >= 0 && j == grid1[0].length)) return true;
        if(grid2[i][j] != 1) return true;
        grid2[i][j] = -1;
        boolean result = grid1[i][j] == 1;
        result = result && isIsland(grid1, grid2, i+1, j);
        result = result && isIsland(grid1, grid2, i-1, j);
        result = result && isIsland(grid1, grid2, i, j+1);
        result = result && isIsland(grid1, grid2, i, j-1);
        return result;

        
    }
    public static void landFind(int[][] grid1, int[][] grid2) {
        int row = grid2.length;
        int col = grid2[0].length;
        int lands = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid2[i][j] == 1 && isIsland(grid1,grid2,i,j)) {
                    lands++;
                }
            }
        }
        System.out.println(lands);
    }
    public static void main(String[] args) {
        //int matrix[][] = { {3,7,8} , {9,11,13} , {15,16,17}};
        //System.out.println(lucknumber(matrix).toString());
/*         char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        solverSudoku(board, 0, 0);
         display(board); 
        int[][] points = {{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}};
        System.out.println(maxPoints(points));
        */
        //System.out.println(searching(new int[][] {{1,3,5,7},{11,12,16,20},{30,32,34,60}}, 60));
        zeros(new int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1}});
        
    }
}
