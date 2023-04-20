/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shortmazepath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author skyla
 */
public class ShortestPathMaze {
    private int[][] maze;
    private boolean[][] visited;
    private int shortestPath;

    public ShortestPathMaze(int[][] maze) {
        this.maze = maze;
        visited = new boolean[maze.length][maze[0].length];
        shortestPath = Integer.MAX_VALUE;
    }

    public int solve() {
        explore(0, 0, 0, new ArrayList<>());
        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
    }

    public void explore(int row, int col, int pathLength, List<int[]> path) {
        if (col == maze[0].length - 1) {
            // Reached the end column, update shortest path if necessary
            if (pathLength + 1 < shortestPath) {
                shortestPath = pathLength + 1;
                printPath(path);
            }
            return;
        }

        visited[row][col] = true;
        path.add(new int[]{row, col});

        // Check all adjacent cells
        if (row > 0 && maze[row - 1][col] == 1 && !visited[row - 1][col]) {
            explore(row - 1, col, pathLength + 1, path);
        }
        if (row < maze.length - 1 && maze[row + 1][col] == 1 && !visited[row + 1][col]) {
            explore(row + 1, col, pathLength + 1, path);
        }
        if (col > 0 && maze[row][col - 1] == 1 && !visited[row][col - 1]) {
            explore(row, col - 1, pathLength + 1, path);
        }
        if (col < maze[0].length - 1 && maze[row][col + 1] == 1 && !visited[row][col + 1]) {
            explore(row, col + 1, pathLength + 1, path);
        }

        visited[row][col] = false;
        path.remove(path.size() - 1);
    }

    public void printPath(List<int[]> path) { //not working with runner, need to fix
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1 && !path.contains(i * maze[0].length + j)) {
                    System.out.print("0 ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}