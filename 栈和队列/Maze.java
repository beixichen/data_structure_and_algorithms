/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 栈和队列;

/**
 *
 * @author fx50jk
 */
public class Maze {

    public static int ExitX = 8;
    public static int ExitY = 10;
    public static int[][] MAZE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
    {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
    {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
    {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
    {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
    {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1},
    {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int x = 1, y = 1;
        TraceRecord path = new TraceRecord();
        System.out.println("迷宫的路径（0）");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
        while (x <= ExitX && y <= ExitY) {
            MAZE[x][y] = 2;
            if (MAZE[x - 1][y] == 0) {
                x -= 1;
                path.insert(x, y);
            } else if (MAZE[x + 1][y] == 0) {
                x += 1;
                path.insert(x, y);
            } else if (MAZE[x][y - 1] == 0) {
                y -= 1;
                path.insert(x, y);
            } else if (MAZE[x][y + 1] == 0) {
                y += 1;
                path.insert(x, y);
            } else if (chkExit(x, y, ExitX, ExitY) == 1) {
                break;
            } else {
                MAZE[x][y] = 2;
                path.delete();
                x = path.last.x;
                y = path.last.y;
            }

        }
        System.err.println("老鼠走过的路径(2)");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println("");
        }
    }

    private static int chkExit(int x, int y, int ExitX, int ExitY) {
        if (x == ExitX && y == ExitY) {
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2) {
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 2 || MAZE[x][y + 1] == 1) {
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 2 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1) {
                return 1;
            }
            if (MAZE[x - 1][y] == 2 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

}
