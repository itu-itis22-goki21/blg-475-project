package sonnet46.task109;

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
        assertTrue(s.moveOneBall(new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))));
        assertTrue(s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 10, 1, 2))));
        assertFalse(s.moveOneBall(new ArrayList<>(Arrays.asList(4, 3, 1, 2))));
        assertFalse(s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 4, 1, 2))));
        assertTrue(s.moveOneBall(new ArrayList<>(List.of())));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single element is always sortable
        assertTrue(s.moveOneBall(new ArrayList<>(List.of(7))));
        // Already sorted
        assertTrue(s.moveOneBall(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        // Reverse sorted — multiple descents, not sortable by one rotation
        assertFalse(s.moveOneBall(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1))));
        // Two elements — always works
        assertTrue(s.moveOneBall(new ArrayList<>(Arrays.asList(2, 1))));
    }
}
