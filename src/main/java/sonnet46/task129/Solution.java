package sonnet46.task129;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given a grid with N rows and N columns (N >= 2) and a positive integer k,
     * each cell of the grid contains a value. Every integer in the range [1, N*N]
     * inclusive appears exactly once on the cells of the grid.
     *
     * You have to find the minimum path of length k in the grid.
     * Return an ordered list of the values on the cells that the minimum path goes through.
     *
     * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 3 => Output: [1, 2, 1]
     * Input: grid = [[5,9,3],[4,1,6],[7,8,2]], k = 1 => Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        int n = grid.size();
        int row = -1, col = -1;
        // Find position of cell with value 1
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
        // Find minimum neighbor of cell 1
        int minNeighbor = Integer.MAX_VALUE;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nr = row + d[0], nc = col + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                minNeighbor = Math.min(minNeighbor, grid.get(nr).get(nc));
            }
        }
        // Build the result: alternate 1 and minNeighbor
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(i % 2 == 0 ? 1 : minNeighbor);
        }
        return result;
    }
}
