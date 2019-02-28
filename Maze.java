import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze{

  private char[][]maze;
  private boolean animate;

  public Maze(String filename) {
    ArrayList<String> a = new ArrayList<String>();
    try {
      File text = new File(filename);
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
    maze = new char[a.size()][a.get(0).length()];
    for (int i = 0;i < maze.length;i += 1) {
      for (int j = 0;j < maze[i].length;j += 1) {
        maze[i][j] = a.get(i).charAt(j);
      }
      animate = false;
    }

    /*for (int i = 0;i < maze.length;i += 1) {
      for (int j = 0;j < maze[i].length;j += 1) {
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }*/
  }

  private void wait(int millis) {
    try{
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {

    }
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public void clearTerminal() {
    System.out.println("\033[2J\033[1;1H");
  }

  public String toString() {
    String ans = "";
    for (int i = 0;i < maze.length;i += 1) {
      for (int j = 0;j < maze[i].length;j += 1) {
        ans += maze[i][j];
      }
      ans += "\n";
    }
    return ans;
  }

  public int solve() {
    return 0;
  }

  private int solve(int row, int col) {
    return 0;
  }
}
