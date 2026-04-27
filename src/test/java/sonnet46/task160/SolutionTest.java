package sonnet46.task160;

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
        assertEquals(37, s.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
        assertEquals(9, s.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
        assertEquals(8, s.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")),
                new ArrayList<>(Arrays.asList(7, 3, 4))));
        assertEquals(1953132, s.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")),
                new ArrayList<>(Arrays.asList(7, 5, 3, 2))));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single addition
        assertEquals(5, s.doAlgebra(new ArrayList<>(List.of("+")),
                new ArrayList<>(Arrays.asList(2, 3))));
        // Single subtraction
        assertEquals(3, s.doAlgebra(new ArrayList<>(List.of("-")),
                new ArrayList<>(Arrays.asList(5, 2))));
        // Single multiplication
        assertEquals(12, s.doAlgebra(new ArrayList<>(List.of("*")),
                new ArrayList<>(Arrays.asList(3, 4))));
        // Floor division
        assertEquals(2, s.doAlgebra(new ArrayList<>(List.of("/")),
                new ArrayList<>(Arrays.asList(7, 3))));
        // Single exponentiation
        assertEquals(8, s.doAlgebra(new ArrayList<>(List.of("**")),
                new ArrayList<>(Arrays.asList(2, 3))));
        // Unknown operator passes through all loops untouched: hits else{i++} in the +/- loop
        assertEquals(5, s.doAlgebra(new ArrayList<>(List.of("<<")),
                new ArrayList<>(Arrays.asList(5, 3))));
    }
}
