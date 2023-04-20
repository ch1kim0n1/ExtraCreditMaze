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
            {1, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1}
        };
        ShortestPathMaze shortestPathMaze = new ShortestPathMaze(maze);
        int shortestPath = shortestPathMaze.shortestPath();
        System.out.println("Shortest path of " + shortestPath);
        shortestPathMaze.printSolvedMaze();
    }
}
