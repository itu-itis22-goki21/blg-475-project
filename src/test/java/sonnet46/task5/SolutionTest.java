package sonnet46.task5;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals(List.of(), s.intersperse(new ArrayList<>(List.of()), 7));
        assertEquals(Arrays.asList(5, 8, 6, 8, 3, 8, 2),
                s.intersperse(new ArrayList<>(Arrays.asList(5, 6, 3, 2)), 8));
        assertEquals(Arrays.asList(2, 2, 2, 2, 2),
                s.intersperse(new ArrayList<>(Arrays.asList(2, 2, 2)), 2));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single element: no delimiter inserted
        assertEquals(List.of(1), s.intersperse(new ArrayList<>(List.of(1)), 99));
        // Two elements: one delimiter
        assertEquals(Arrays.asList(1, 0, 2), s.intersperse(new ArrayList<>(Arrays.asList(1, 2)), 0));
        // Negative delimiter
        assertEquals(Arrays.asList(1, -1, 2, -1, 3),
                s.intersperse(new ArrayList<>(Arrays.asList(1, 2, 3)), -1));
    }
}
