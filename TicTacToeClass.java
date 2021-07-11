public class TicTacToeClass
{
	// Instance Variables
	private char[][] board;
	private int turns;

	// Constructors
	public TicTacToeClass()
	{
		board = new char[3][3];			// A two-dimensional array of chars
		turns = 0;						// Keeps track of number of turns

		for ( int r=0; r<3; r++ )		// Creates the visual of rows and columns
			for ( int c=0; c<3; c++ )	//		for the Tic Tac Toe board
				board[r][c] = ' ';
	}

	// Accessor Methods

	// RESOLVED
	public boolean isWinner( char p )	// Returns true if the letter passed in currently has three in a row
	{
		
	// Shorter Option
		
		// horizontal win
		for (int r = 0; r < 3; r++) {
			if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
				return true;
			}
		}
		
		// vertical win
		for (int c = 0; c < 3; c++)	{
			if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
				return true;
			}
		}
		
		// diagonal win
		if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		} else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		
		// if no winner yet
		else {
			return false;
		}
	
	/*
	Alternative Option (longer)
	
		if(board[0][0] == p && board[0][1] == p && board[0][2] == p)
			return true;
		if(board[1][0] == p && board[1][1] == p && board[1][2] == p)
			return true;
		if(board[2][0] == p && board[2][1] == p && board[2][2] == p)
			return true;
		if(board[0][0] == p && board[1][0] == p && board[2][0] == p)
			return true;
		if(board[0][1] == p && board[1][1] == p && board[2][1] == p)
			return true;
		if(board[0][2] == p && board[1][2] == p && board[2][2] == p)
			return true;
		if(board[0][0] == p && board[1][1] == p && board[2][2] == p)
			return true;
		if(board[0][2] == p && board[1][1] == p && board[2][0] == p)
			return true;
		else return false;
	*/
		
	}

	// RESOLVED
	public boolean isFull()				// Returns true if 9 turns have been played
	{
		if (turns == 9) {
			return true;
		} else {
			return false;
		}
	}

	// RESOLVED
	public boolean isCat()				// Returns true if all nine spaces are filled AND neither X nor O has won (tied)
	{
		if (isFull() == true && isWinner('X') == false && isWinner('O') == false) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValid( int r, int c )		// Returns true if the given row and column corresponds to a valid space on the board
	{
		if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
			return true;
		else
			return false;
	}

	public int numTurns()				// Returns number of turns played so far
	{
		return turns;
	}

	public char playerAt( int r, int c )	// Returns the character representing the piece at the given location (should return either an empty space, x, or o)
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';						// Returns @ if not ' ' or X or O
	}

	public void displayBoard()				// Displays the current board on the screen
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// UNRESOLVED
	// Modifiers
	public void playMove( char p, int r, int c )	// Allows the given player to place their move at the given row and column.
	{
		board[r][c] = p;
		turns++;
	}

}