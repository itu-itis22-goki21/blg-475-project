package sonnet46.task8;

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
        assertEquals(Arrays.asList(0, 1), s.sumProduct(new ArrayList<>(List.of())));
        assertEquals(Arrays.asList(3, 1), s.sumProduct(new ArrayList<>(Arrays.asList(1, 1, 1))));
        assertEquals(Arrays.asList(100, 0), s.sumProduct(new ArrayList<>(Arrays.asList(100, 0))));
        assertEquals(Arrays.asList(15, 105), s.sumProduct(new ArrayList<>(Arrays.asList(3, 5, 7))));
        assertEquals(Arrays.asList(10, 10), s.sumProduct(new ArrayList<>(List.of(10))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Negative numbers
        assertEquals(Arrays.asList(-3, 2), s.sumProduct(new ArrayList<>(Arrays.asList(-1, -2))));
        // All zeros
        assertEquals(Arrays.asList(0, 0), s.sumProduct(new ArrayList<>(Arrays.asList(0, 0, 0))));
        // Large list
        assertEquals(Arrays.asList(10, 24), s.sumProduct(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
    }
}
