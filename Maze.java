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
}
