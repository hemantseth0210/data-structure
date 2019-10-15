package com.sethjava.rotatematrix;

import java.util.Arrays;

// Time Complexity : O(N^2), touches all N^2 elements
public class RotateMatrix90Clockwise
{
    static int[][] rotate90Clockwise(int[][] matrix) {
        int N = matrix.length;
        for(int x = 0; x < N/2; x++){
            for(int y = x; y < N - 1 - x; y++){
                int top = matrix[x][y];
                // Left -> Top
                matrix[x][y] = matrix[N-1-y][x];
                // Bottom -> Left
                matrix[N-1-y][x] = matrix[N-1-x][N-1-y];
                // Right to Bottom
                matrix[N-1-x][N-1-y] = matrix[y][N-1-x];
                // Top -> Right
                matrix[y][N-1-x] = top;
            }
        }
        return matrix;
    }


    public static void main( String[] args )
    {
        int matrix[][] = {
                { 00, 01, 02, 03 },
                { 10, 11, 12, 13 },
                { 20, 21, 22, 23 },
                { 30, 31, 32, 33}
        };
        System.out.println( "Given matrix " );
        for(int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
        matrix = rotate90Clockwise(matrix);
        System.out.println( "Rotated matrix " );
        for(int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
