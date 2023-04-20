/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shortmazepath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author skyla
 */
public class ShortestPathMaze {
    private int[][] maze;
    private boolean[][] visited;
    private int[][] solvedMaze;
    private int numRows, numCols;
    private int[] rowOffsets = {-1, 0, 1, 0};
    private int[] colOffsets = {0, 1, 0, -1};

    public ShortestPathMaze(int[][] maze) {
        this.maze = maze;
        numRows = maze.length;
        numCols = maze[0].length;
        visited = new boolean[numRows][numCols];
        this.solvedMaze = new int[numRows][numCols];
    }

    public int shortestPath() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // starting position with distance 0
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if (col == numCols - 1) {
                markSolvedPath(row, col);
                return dist + 1; // add 1 to include the last cell in the path
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowOffsets[i];
                int newCol = col + colOffsets[i];
                if (isValid(newRow, newCol) && maze[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1; // no path found
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
    
    private void markSolvedPath(int row, int col) {
        while (col >= 0 && row >= 0 && col < numCols && row < numRows) {
            solvedMaze[row][col] = 1;
            int newRow = row;
            int newCol = col;
            for (int i = 0; i < 4; i++) {
                int r = row + rowOffsets[i];
                int c = col + colOffsets[i];
                if (isValid(r, c) && maze[r][c] == 1 && visited[r][c] && solvedMaze[r][c] == 0) {
                    newRow = r;
                    newCol = c;
                    break;
                }
            }
            if (newRow == row && newCol == col) {
                break;
            }
            row = newRow;
            col = newCol;
        }
    }
    
    public void printSolvedMaze() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(solvedMaze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
