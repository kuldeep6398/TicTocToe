/* Project of Tic Toc Toe. */

import java.util.Scanner;

public class TicTocToe
{
	private static char[][]board = new char[3][3];
	private static char currentPlayer = 'X';
	public static void main(String... s)
	{
		System.out.println("**********Welcome to Tic Toc Toe Game**********");
		System.out.println();
		int n = 1;
		while(n == 1)
		{
			System.out.println();
			initializeBoard();
			playGame();
			System.out.println();
			System.out.println("Do you want to continue (press 1 to continue) or (0 for exit)");
		    n = new Scanner(System.in).nextInt();
		}
			System.out.println();
			System.out.println();
			System.out.println("Made by -> Kuldeep sharma");
	}
	private static void initializeBoard()
	{
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				board[i][j] = '-';
			}
		}
	}
	private static void playGame()
	{
		while(true)
		{
			printBoard();
			makeMove();
			if(checkWin())
			{
				printBoard();
				System.out.println("Player "+currentPlayer+" Wins");
				break;
			}
			if(checkDraw())
			{
				printBoard();
				System.out.println("It's a draw");
				break;
			}
			switchPlayer();
		}
	}
	private static void printBoard()
	{
		System.out.println("-------");
		for(int i = 0; i<3; i++)
		{
			if(i == 0 || i == 1 || i == 2)
			{
				System.out.print("|");
			}
			for(int j = 0; j<3; j++)
			{
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
			System.out.println("-------");
		}
	}
	
	private static void makeMove()
	{
		System.out.println("Player "+currentPlayer+"s turn.");
		System.out.print("Enter row(1-3): ");
		int row = new Scanner(System.in).nextInt()-1;
		System.out.print("Enter column(1-3): ");
		int col = new Scanner(System.in).nextInt()-1;
		if(row<0 || row>2 || col<0 || col>2)
		{
			System.out.println("Invalid input. Try again.");
			makeMove();
		}
		else
		{
			board[row][col] = currentPlayer;
		}
	}
	
	private static boolean checkWin()
	{
		//check rows
		for(int i = 0; i<3; i++)
		{
			if((board[i][0] == board[i][1])&&(board[i][1] == board[i][2]) && board[i][0] != '-')
			{
				return true;
			}
		}
		//check column
		for(int i = 0; i<3; i++)
		{
			if((board[0][i] == board[1][i])&&(board[1][i] == board[2][i])&& board[0][i] != '-')
			{
				return true;
			}
		}
		// check diagonals
		if(((board[0][0] == board[1][1])&&(board[1][1] == board[2][2])&& board[0][0] != '-') || ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && board[0][2] != '-'))
		{
			return true;
		}
		return false;
	}
	
	private static boolean checkDraw()
	{
		for(int i = 0;  i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				if(board[i][j] == '-')
				{
					return false;
				}
			}
		} 
		return true;
		
	}
	
	private static void switchPlayer()
	{
		currentPlayer = (currentPlayer == 'X')?'O':'X';
	}

}