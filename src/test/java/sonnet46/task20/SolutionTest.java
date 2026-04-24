package sonnet46.task20;

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
        assertEquals(Arrays.asList(3.9, 4.0),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.9, 4.0, 5.0, 2.2))));
        assertEquals(Arrays.asList(5.0, 5.9),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 5.9, 4.0, 5.0))));
        assertEquals(Arrays.asList(2.0, 2.2),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.2))));
        assertEquals(Arrays.asList(2.0, 2.0),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 2.0))));
        assertEquals(Arrays.asList(2.2, 3.1),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.1, 4.1, 5.1))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Minimum two-element list
        assertEquals(Arrays.asList(1.0, 5.0),
                s.findClosestElements(new ArrayList<>(Arrays.asList(1.0, 5.0))));
        // Negative numbers
        assertEquals(Arrays.asList(-3.0, -2.0),
                s.findClosestElements(new ArrayList<>(Arrays.asList(-3.0, -2.0, 5.0))));
        // Identical elements
        assertEquals(Arrays.asList(4.0, 4.0),
                s.findClosestElements(new ArrayList<>(Arrays.asList(4.0, 4.0, 10.0))));
    }
}
