package sonnet46.task25;

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
        assertEquals(List.of(2), s.factorize(2));
        assertEquals(Arrays.asList(2, 2), s.factorize(4));
        assertEquals(Arrays.asList(2, 2, 2), s.factorize(8));
        assertEquals(Arrays.asList(3, 19), s.factorize(3 * 19));
        assertEquals(Arrays.asList(3, 3, 19, 19), s.factorize(3 * 19 * 3 * 19));
        assertEquals(Arrays.asList(2, 3, 3), s.factorize(3 * 2 * 3));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Large prime — remainder branch taken after loop
        assertEquals(Arrays.asList(97), s.factorize(97));
        // Mixed factors
        assertEquals(Arrays.asList(2, 5, 7), s.factorize(70));
        // n=25
        assertEquals(Arrays.asList(5, 5), s.factorize(25));
    }
}
