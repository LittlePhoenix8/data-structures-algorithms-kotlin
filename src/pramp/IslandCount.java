package pramp;

import java.util.LinkedList;
import java.util.Queue;
/**
 * https://www.pramp.com/challenge/yZm60L6d5juM7K38KYZ6
 * **/
public class IslandCount {
    //dfs
    static int getNumberOfIslands(int[][] binaryMatrix) {
        if(binaryMatrix.length == 0) {
            return 0;
        }
        if(binaryMatrix.length == 1 && binaryMatrix[0].length == 1) {
            return (binaryMatrix[0][0] == 1)? 1 : 0;
        }
        int n = binaryMatrix.length;
        int m = binaryMatrix[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(binaryMatrix[i][j] == 1) {
                    getNumber(i, j, binaryMatrix, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    static void getNumber(int i, int j, int[][] matrix, int n, int m) {
        if(i - 1 > 0 && matrix[i - 1][j] == 1) {
            matrix[i - 1][j] = -1;
            getNumber(i -1, j, matrix, n, m);
        }
        if(i + 1 < n && matrix[i + 1][j] == 1) {
            matrix[i + 1][j] = -1;
            getNumber(i +1, j, matrix, n, m);
        }
        if(j - 1 > 0 && matrix[i][j -1] == 1) {
            matrix[i][j - 1] = -1;
            getNumber(i, j - 1, matrix, n, m);
        }
        if(j + 1 < m && matrix[i][j +1] == 1) {
            matrix[i][j + 1] = -1;
            getNumber(i, j + 1, matrix, n, m);
        }
    }

    //iterative with queue
    static int getNumberOfIslandsQueue(int[][] binaryMatrix) {
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;
        int islands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(binaryMatrix[i][j] == 1) {
                    markIsland(binaryMatrix, rows, cols, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    static void markIsland(int[][] binaryMatrix, int rows, int cols, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            int x = item[0];
            int y = item[1];
            if (binaryMatrix[x][y] == 1) {
                binaryMatrix[x][y] = -1;
                //check the rest of the matrix
                pushIfValid(queue, rows, cols, x - 1, y);
                pushIfValid(queue, rows, cols, x + 1, y);
                pushIfValid(queue, rows, cols, x, y - 1);
                pushIfValid(queue, rows, cols, x, y + 1);
            }
        }
    }

    static void pushIfValid(Queue<int[]> queue, int rows, int cols, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            queue.add(new int[] { x, y });
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { new int[] { 0, 1, 0, 1, 0 },
                new int[] { 0, 0, 1, 1, 1 },
                new int[] { 1, 0, 0, 1, 0 },
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 1, 0, 1, 0, 1 } };
        int[][] matrix2 = new int[][] { new int[] { 1, 0, 1, 0 } };
        int[][] matrix3 = new int[][] { new int[] { 1,0,1,0 }, new int[] { 0,1,1,1 }, new int[] { 0,0,1,0 } };

        System.out.println("DFS");
        System.out.println(getNumberOfIslands(matrix)); //6
        System.out.println(getNumberOfIslands(matrix2)); //2
        System.out.println(getNumberOfIslands(matrix3)); //2

        System.out.println("Iterative");
        System.out.println(getNumberOfIslandsQueue(matrix)); //6
        System.out.println(getNumberOfIslandsQueue(matrix2)); //2
        System.out.println(getNumberOfIslandsQueue(matrix3)); //2
    }
}
