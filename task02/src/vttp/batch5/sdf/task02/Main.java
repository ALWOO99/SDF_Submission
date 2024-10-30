package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	private static String[][] board = new String[3][3];
	private static String[][] legalPosition = new String[3][3];
	

	// static List<String> data = new ArrayList<>();
	public Main() {

		// initBoard();
	}

	// Initialize the board with empty spaces
	/*
	 * public void initBoard() throws IOException {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) {
		String file = args[0];

		try {

			System.out.println("Board:");
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			
//Not sure why it only takes in the last line unable to debug.

			while ((line = br.readLine()) != null) {
				
				for (int rows = 0; rows < 3; rows++) {
					for (int cols = 0; cols < 3; cols++) {

						board[rows][cols] = String.valueOf(line.charAt(cols));
						
					}
					
				}
				

			}
			br.close();

			displayBoard();
			checkMoves();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void displayBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s", board[i][j]);
			}
			System.out.println();

		}

	}

	public static void checkMoves() {
		System.out.println("---------------");
		int utility = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (board[i][j].equals("X") || board[i][j].equals("O")) {
					continue;

				}

				if(checkWin(board[i][j]) == true && isBoardFull() == false)
				utility = 1;


				if(checkWin(board[i][j]) == false && isBoardFull() == false)
				utility = -1;

				if(checkWin(board[i][j]) == false && isBoardFull() == true)
				utility = 0;

				System.out.printf("y= %d, x=%d utility= %d\n", j, i, utility);

			}
		}

	}

	public static boolean checkWin(String mark) {
        // Check rows
        for (int x = 0; x < 3; x++) {
            if (board[x][0].equals(mark) && board[x][1].equals(mark) && board[x][2].equals(mark)) {
                return true;
            }
        }

        // Check columns
        for (int y = 0; y < 3; y++) {
            if (board[0][y].equals(mark) && board[1][y].equals(mark) && board[2][y].equals(mark)) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(mark) && board[1][1].equals(mark) && board[2][2].equals(mark)) {
            return true;
        }

        if (board[0][2].equals(mark) && board[1][1].equals(mark) && board[2][0].equals(mark)) {
            return true;
        }

        return false;
    }

	public static boolean isBoardFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y <3; y++) {
                if (board[x][y].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }

}
