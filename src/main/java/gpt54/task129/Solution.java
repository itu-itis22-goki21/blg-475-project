package gpt54.task129;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a grid with N rows and N columns (N >= 2) and a positive integer k,
    each cell of the grid contains a value. Every integer in the range [1, N * N]
    inclusive appears exactly once on the cells of the grid.

    You have to find the minimum path of length k in the grid. You can start
    from any cell, and in each step you can move to any of the neighbor cells,
    in other words, you can go to cells which share an edge with you current
    cell.
    Please note that a path of length k means visiting exactly k cells (not
    necessarily distinct).
    You CANNOT go off the grid.
    A path A (of length k) is considered less than a path B (of length k) if
    after making the ordered lists of the values on the cells that A and B go
    through (let's call them lst_A and lst_B), lst_A is lexicographically less
    than lst_B, in other words, there exist an integer index i (1 <= i <= k)
    such that lst_A[i] < lst_B[i] and for any j (1 <= j < i) we have
    lst_A[j] = lst_B[j].
    It is guaranteed that the answer is unique.
    Return an ordered list of the values on the cells that the minimum path go through.

    Examples:

        Input: grid = [ [1,2,3], [4,5,6], [7,8,9]], k = 3
        Output: [1, 2, 1]

        Input: grid = [ [5,9,3], [4,1,6], [7,8,2]], k = 1
        Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        validateGrid(grid, k);

        int n = grid.size();
        int row = 0;
        int col = 0;

        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    row = i;
                    col = j;
                    break outer;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(1);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int step = 1; step < k; step++) {
            int bestValue = Integer.MAX_VALUE;
            int nextRow = row;
            int nextCol = col;

            for (int[] direction : directions) {
                int candidateRow = row + direction[0];
                int candidateCol = col + direction[1];
                if (candidateRow >= 0 && candidateRow < n && candidateCol >= 0 && candidateCol < n) {
                    int candidateValue = grid.get(candidateRow).get(candidateCol);
                    if (candidateValue < bestValue) {
                        bestValue = candidateValue;
                        nextRow = candidateRow;
                        nextCol = candidateCol;
                    }
                }
            }

            row = nextRow;
            col = nextCol;
            path.add(grid.get(row).get(col));
        }

        return path;
    }

    private void validateGrid(List<List<Integer>> grid, int k) {
        if (grid == null || grid.size() < 2) {
            throw new IllegalArgumentException("grid must be at least 2x2");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k must be positive");
        }

        int n = grid.size();
        Set<Integer> seen = new HashSet<>();
        for (List<Integer> row : grid) {
            if (row == null || row.size() != n) {
                throw new IllegalArgumentException("grid must be square");
            }
            for (Integer value : row) {
                if (value == null || !seen.add(value)) {
                    throw new IllegalArgumentException("grid values must be unique and non-null");
                }
            }
        }

        for (int expected = 1; expected <= n * n; expected++) {
            if (!seen.contains(expected)) {
                throw new IllegalArgumentException("grid must contain every value from 1 to N^2");
            }
        }
    }
}

