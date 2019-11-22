package Ch_12_Practice;

public class EightQueens{
    final int N = 8; 
  
    //method to print solution
    public void printSolution(int [][] board){ 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
  
    //method to check for attacking queens
    public boolean isSafe(int [][] board, int row, int col){ 
        int i, j; 
  
        //left row check
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        //left upper diag check
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        //left lower diag check
        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    private boolean solveQueens(int [][] board, int col){ 
         //WRITE ME!
    }
  
    //sets up initial 8x8 board
    public boolean solveNQ(int [][] board){  
        if (solveQueens(board, 0) == false) { 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
  
        printSolution(board); 
        return true; 
    } 
  
    //main method 
    public static void main(String [] args){
      int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0}, 
                        { 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0} };  
                       
      EightQueens Queen = new EightQueens();
      Queen.solveNQ(board);
    } 
}