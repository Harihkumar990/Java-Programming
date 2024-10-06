public class MagicSquareGrid {
    public static int numMagicSquaresInside(int[][] grid, int row, int col) {
        int sum = 0;
        for(int i=0 ;i<grid.length && row >= 3; i++) {
            for(int j=0; j<grid[i].length && col >=3; j++) {
                if(solver(grid, i, j)) {
                    sum++;
                }
                --col;
            }
            --row;
        }
        return sum;


    }
    public static boolean solver(int[][] grid, int row, int col) {
        int rowSum = 0;
        int colSum = 0;
        int digSum = 0;
        for(int j = col; j<3; j++) {
            rowSum += grid[row][j];
        }
        for(int i=0; i<3; i++) {
            colSum += grid[i][col];
        }
        for(int dg=0; dg<3; dg++) {
            digSum += grid[dg][dg];
        }
        return (rowSum == colSum) && (rowSum == digSum);
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int row = grid.length;
        int col = grid[0].length;
        System.out.println(numMagicSquaresInside(grid, row, col));
    }
}
