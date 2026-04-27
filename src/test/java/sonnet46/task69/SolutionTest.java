package sonnet46.task69;

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
        assertEquals(1, s.search(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 1))));
        assertEquals(4, s.search(new ArrayList<>(Arrays.asList(4, 1, 4, 1, 4, 4))));
        assertEquals(-1, s.search(new ArrayList<>(Arrays.asList(3, 3))));
        assertEquals(8, s.search(new ArrayList<>(Arrays.asList(8, 8, 8, 8, 8, 8, 8, 8))));
        assertEquals(2, s.search(new ArrayList<>(Arrays.asList(2, 3, 3, 2, 2))));
        assertEquals(1, s.search(new ArrayList<>(List.of(1))));
        assertEquals(-1, s.search(new ArrayList<>(List.of(10))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // freq(2)=2 >= 2, freq(3)=3 >= 3 → max is 3
        assertEquals(3, s.search(new ArrayList<>(Arrays.asList(2, 2, 3, 3, 3))));
        // No value qualifies
        assertEquals(-1, s.search(new ArrayList<>(Arrays.asList(5, 5, 4, 4, 4))));
        // Docstring example
        assertEquals(2, s.search(new ArrayList<>(Arrays.asList(4, 1, 2, 2, 3, 1))));
        // val=0 in the map hits the val > 0 FALSE branch (short-circuit); val=1 qualifies
        assertEquals(1, s.search(new ArrayList<>(Arrays.asList(0, 0, 1))));
    }
}
