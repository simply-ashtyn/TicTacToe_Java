
import java.util.Scanner;

public class TicTacToe{

    public static void printGameBoard(char[] board)
    {
        System.out.println( board[0] + " | " +  board[1] + " | " + board[2]);
        System.out.println( " - + - + - " );
        System.out.println( board[3] + " | " +  board[4] + " | " + board[5]);
        System.out.println( " - + - + - " );
        System.out.println( board[6] + " | " +  board[7] + " | " + board[8]);
    }

    public static void main(String[] args)
    {
        boolean playGame = true;

        while(playGame)
        {
            //  VARIABLES
            char[] board = {'1','2','3',
                        '4', '5','6',
                        '7','8','9'};
            int numberOfSquaresPlayed = 0;
            char whoseTurnItIs = 'X';

            // GAME FUNCTION
            while(numberOfSquaresPlayed < 9)
            {
                printGameBoard(board);
                System.out.printf("Chose a square player %s: ", whoseTurnItIs);
                Scanner input = new Scanner(System.in);
                boolean validInput = false;

                while(!validInput)
                {
                    int playerInput = input.nextInt();
                    if(playerInput > 9 || playerInput == 0)
                    {
                        System.out.println("Invalid option, please try again");
                    }
                    else
                    {
                        board[playerInput-1] = whoseTurnItIs;
                        numberOfSquaresPlayed++;
                        break;
                    }
                }

                // CHECK FOR WINNING MOVE
                if((board[0] + board[1] + board[2] == (whoseTurnItIs * 3)) // first row 
                || (board[3] + board[4] + board[5] == (whoseTurnItIs * 3)) // second row
                || (board[6] + board[7] + board[8] == (whoseTurnItIs * 3)) // third row
                || (board[0] + board[3] + board[6] == (whoseTurnItIs * 3)) // first column
                || (board[1] + board[4] + board[7] == (whoseTurnItIs * 3)) // second column
                || (board[2] + board[5] + board[8] == (whoseTurnItIs * 3)) // third column
                || (board[0] + board[4] + board[8] == (whoseTurnItIs * 3)) // first diagonal
                || (board[2] + board[4] + board[6] == (whoseTurnItIs * 3))) // second diagonal
                {
                    printGameBoard(board);
                    System.out.println(whoseTurnItIs + " congragulations, you win!");
                    break;
                }
                else
                {
                    whoseTurnItIs = (whoseTurnItIs == 'X') ? 'O' : 'X';
                }

                if(numberOfSquaresPlayed == 9)
                {
                    printGameBoard(board);
                    System.out.println("It's a tie!");
                }
            }

            System.out.println("Play again?");
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            if(choice.equals("no"))
            {
                playGame = false;
            }
        }
    }
}