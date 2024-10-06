import java.util.*;
public class Nqueens {
    public static int queensPlace(String[][] board, int row,int sum) {
        if(row == board.length) {
            sum++;
            return sum;
        }
        for(int i=0; i<board[row].length; i++) {
            if(isplaced(board,row,i)) {
                board[row][i] = "Q";
                sum = queensPlace(board, row+1,sum);
                board[row][i] = ".";

            }
        }
        return sum;

    }
    public static boolean isplaced(String[][] board, int row, int col) {
        for(int i=row-1; i>=0; i--) {
            if(board[i][col].equals("Q")) {
                return false;
            }
        }
        for(int i=row-1,j=col-1; i>=0 && j>=0; j--,i--) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<board[i].length; i--,j++ ) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }
   
    public static void main(String[] args) {
        String[][] borad = {{".","."},{".","."}};
        
        int sum = 0;
        System.out.println(queensPlace(borad, 0,sum));
       
    }
}
