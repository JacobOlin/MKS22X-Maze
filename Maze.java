import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze{
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<String>();
    try {
      File text = new File("Maze1.txt");
      Scanner s = new Scanner(text);
      while (s.hasNextLine()) {
        String temp = s.nextLine();
        //System.out.println(temp);
        a.add(temp);
      }
    }catch(FileNotFoundException e) {
      System.out.println("Oh no");
    }
    /*System.out.println("------------------");
    for (int i = 0;i < a.size();i += 1) {
      System.out.println(a.get(i));
    }*/
    char[][] board = new char[a.size()][a.get(0).length()];
    for (int i = 0;i < board.length;i += 1) {
      for (int j = 0;j < board[i].length;j += 1) {
        board[i][j] = a.get(i).charAt(j);
      }
    }

    /*for (int i = 0;i < board.length;i += 1) {
      for (int j = 0;j < board[i].length;j += 1) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }*/
  }
}
