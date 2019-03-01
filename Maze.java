import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze{

  private char[][]maze;
  private boolean animate;

  public Maze(String filename) throws FileNotFoundException{
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
        if (maze[i][j] == '.') {
          ans += ' ';
        }
        else {
          ans += maze[i][j];
        }
      }
      ans += "\n";
    }
    return ans;
  }

  public int solve() {
    int row = 0;
    int col = 0;
    for (int i = 0;i < maze.length;i += 1) {
      for (int j = 0;j < maze[i].length;j += 1) {
        if (maze[i][j] == 'S') {
          row = i;
          col = j;
        }
      }
    }
    return solve(row,col);
  }

  private int solve(int row, int col) {
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    if (maze[row][col] == 'E') {
      return 1;
    }
    int r = 0;
    int[][] moves = {{0,1},{0,-1},{-1,0},{1,0}};
    for (int i = 0;i < moves.length;i += 1) {
      char a = maze[row+moves[i][0]][col+moves[i][1]];
      if (a == ' ' || a == 'E') {
        maze[row][col] = '@';
        r += solve(row+moves[i][0],col+moves[i][1]);
      }
    }
    if (r > 0) {
      return r + 1;
    }
    maze[row][col] = '.';
    return 0;
  }
}
