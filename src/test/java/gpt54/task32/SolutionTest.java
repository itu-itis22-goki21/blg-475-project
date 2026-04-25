package gpt54.task32;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static final double EPSILON = 1e-6;

    private final Solution solution = new Solution();

    @Test
    void evaluatesPolynomialUsingCoefficientIndicesAsPowers() {
        assertEquals(17.0, solution.poly(List.of(1.0, 2.0, 3.0), 2.0), EPSILON);
    }

    @Test
    void findsExpectedRootForLinearPolynomial() {
        assertEquals(-0.5, solution.findZero(List.of(1.0, 2.0)), EPSILON);
    }

    @Test
    void expandsSearchIntervalWhenRootIsOutsideInitialRange() {
        double root = solution.findZero(List.of(-10.0, 1.0));

        assertEquals(0.0, solution.poly(List.of(-10.0, 1.0), root), EPSILON);
    }

    @Test
    void findsAValidRootForHigherDegreePolynomial() {
        List<Double> coefficients = List.of(-6.0, 11.0, -6.0, 1.0);
        double root = solution.findZero(coefficients);

        assertEquals(0.0, solution.poly(coefficients, root), EPSILON);
    }
}
