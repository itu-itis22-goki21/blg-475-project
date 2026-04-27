package sonnet46.task32;

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
        // f(x) = 1 + 2x → zero at x = -0.5
        double z1 = s.findZero(Arrays.asList(1.0, 2.0));
        assertEquals(0.0, s.poly(Arrays.asList(1.0, 2.0), z1), 1e-4);

        // f(x) = -6 + 11x - 6x^2 + x^3 = (x-1)(x-2)(x-3) → zero at x = 1
        double z2 = s.findZero(Arrays.asList(-6.0, 11.0, -6.0, 1.0));
        assertEquals(0.0, s.poly(Arrays.asList(-6.0, 11.0, -6.0, 1.0), z2), 1e-4);
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // f(x) = -1 + 1*x → zero at x = 1
        double z = s.findZero(Arrays.asList(-1.0, 1.0));
        assertEquals(0.0, s.poly(Arrays.asList(-1.0, 1.0), z), 1e-4);

        // Verify poly evaluation itself
        assertEquals(0.0, s.poly(Arrays.asList(0.0, 0.0), 99.0), 1e-10);
        assertEquals(7.0, s.poly(Arrays.asList(7.0), 0.0), 1e-10);
        // Root at x=3: f(-1)<0 and f(1)<0 so product>0, forces the while-loop to expand bounds
        double z2 = s.findZero(Arrays.asList(-3.0, 1.0));
        assertEquals(0.0, s.poly(Arrays.asList(-3.0, 1.0), z2), 1e-4);
    }
}
