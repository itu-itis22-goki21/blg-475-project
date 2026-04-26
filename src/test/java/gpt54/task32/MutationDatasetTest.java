package gpt54.task32;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();
        Random rand = new Random(42);

        for (int i = 0; i < 100; i++) {
            int ncoeff = 2 * (rand.nextInt(3) + 1);
            List<Double> coeffs = new ArrayList<>();
            for (int j = 0; j < ncoeff; j++) {
                int coeff = rand.nextInt(20) - 10;
                if (coeff == 0) {
                    coeff = 1;
                }
                coeffs.add((double) coeff);
            }
            double solution = s.findZero(coeffs);
            assertTrue(Math.abs(s.poly(coeffs, solution)) <= 1e-4);
        }

        assertAll(
                () -> assertPolynomialRoot(s, List.of(-2.0, 1.0)),
                () -> assertPolynomialRoot(s, List.of(-8.0, 0.0, 0.0, 1.0)),
                () -> assertThrows(Throwable.class, () -> s.findZero(List.of(1.0, 0.0, 1.0))),
                () -> assertThrows(Throwable.class, () -> s.findZero(List.of(0.0, 0.0, 0.0)))
        );
    }

    private static void assertPolynomialRoot(Solution s, List<Double> coeffs) {
        double solution = s.findZero(coeffs);
        assertTrue(Math.abs(s.poly(coeffs, solution)) <= 1e-4);
    }
}
