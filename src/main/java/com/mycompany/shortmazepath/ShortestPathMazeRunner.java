/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shortmazepath;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author skyla
 */
public class ShortestPathMazeRunner {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1}
        };

        ShortestPathMaze solver = new ShortestPathMaze(maze);
        int shortestPath = solver.solve();
        if (shortestPath == -1) {
            System.out.println("no path");
        } else {
            System.out.println("shortest path of " + shortestPath);
            solver.printPath(Integer.valueOf(shortestPath));
        }
    }

}