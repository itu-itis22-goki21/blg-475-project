package sonnet46.task58;

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
        assertEquals(Arrays.asList(1, 5, 653),
                s.common(new ArrayList<>(Arrays.asList(1, 4, 3, 34, 653, 2, 5)),
                        new ArrayList<>(Arrays.asList(5, 7, 1, 5, 9, 653, 121))));
        assertEquals(Arrays.asList(2, 3),
                s.common(new ArrayList<>(Arrays.asList(5, 3, 2, 8)),
                        new ArrayList<>(Arrays.asList(3, 2))));
        assertEquals(Arrays.asList(2, 3, 4),
                s.common(new ArrayList<>(Arrays.asList(4, 3, 2, 8)),
                        new ArrayList<>(Arrays.asList(3, 2, 4))));
        assertEquals(List.of(),
                s.common(new ArrayList<>(Arrays.asList(4, 3, 2, 8)),
                        new ArrayList<>(List.of())));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // No common elements
        assertEquals(List.of(),
                s.common(new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(4, 5, 6))));
        // Duplicates in input — result should be unique and sorted
        assertEquals(Arrays.asList(2),
                s.common(new ArrayList<>(Arrays.asList(2, 2, 2)),
                        new ArrayList<>(Arrays.asList(2, 3))));
        // All elements common
        assertEquals(Arrays.asList(1, 2, 3),
                s.common(new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(3, 1, 2))));
    }
}
