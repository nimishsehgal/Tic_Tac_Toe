import java.util.*;

public class tic_tac_toe{

    static String[] board;
    static String turn;

    static String checkWinner()
    {
        for(int i=0; i<8; i++)
        {
            String line="null";

            switch(i)
            {
                case 0: 
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }
            if(line.equals("XXX"))
            {
                System.out.println("X wins.");
                return "X";
            }
            else if(line.equals("OOO"))
            {
                System.out.println("O wins.");
                return "O";
            }
        }
        int flag=0;
        for(int i=0; i<9; i++)
        {
            if(board[i].equals(String.valueOf(i+1)))
            {
                flag=1; break;
            }
        }
        if(flag==1)
        {
            System.out.print("It's "+turn+"'s turn. Enter the slot number to place "+turn+": ");
        }
        else{
            return "draw";
        }
        return null;
    }

    static void printBoard(){
        System.out.println("|-----------|");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
        System.out.println("|-----------|");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        turn="X";
        board=new String[9];
        String winner=null;
        for(int i=0; i<9; i++)
        {
            board[i]=String.valueOf(i+1);
        }
        System.out.println("Welcome to my Tic_Tac_Toe Park: ");
        printBoard();
        System.out.print("X will take first turn. Enter the slot number to place X: ");
        while(winner==null)
        {
            int num;
            num=scanner.nextInt();
            if(num<=0 || num>9)
            {
                System.out.print("Invalid slot number. Re-enter the slot number to place "+turn+": ");
                continue;
            }
            if(board[num-1].equals(String.valueOf(num)))
            {
                board[num-1]=turn;
                if(turn.equals("X")){
                    turn="O";
                }
                else{
                    turn="X";
                }
                printBoard();
                winner=checkWinner();
            }
            else
            {
                System.out.print("Slot already taken. Re-enter any other slot to place "+turn+": ");
            }
        }
        if(winner.equals("draw"))
        {
            System.out.println("The game ended in a draw. Good luck next time.");
        }
        else
        {
            System.out.println("Congratulations on winning the game.");
        }
        scanner.close();
    }
}
