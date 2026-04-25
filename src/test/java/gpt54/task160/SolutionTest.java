package gpt54.task160;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void respectsOperatorPrecedenceAcrossDifferentOperators() {
        assertEquals(9, solution.doAlgebra(List.of("+", "*", "-"), List.of(2, 3, 4, 5)));
    }

    @Test
    void evaluatesExponentiationBeforeMultiplicationAndAddition() {
        assertEquals(37, solution.doAlgebra(List.of("**", "*", "+"), List.of(2, 3, 4, 5)));
    }

    @Test
    void usesLeftAssociativityForOperatorsWithTheSamePrecedence() {
        assertEquals(12, solution.doAlgebra(List.of("-", "-"), List.of(20, 5, 3)));
    }

    @Test
    void keepsExponentiationRightAssociative() {
        assertEquals(512, solution.doAlgebra(List.of("**", "**"), List.of(2, 3, 2)));
    }

    @Test
    void appliesFloorDivisionBeforeLowerPrecedenceOperators() {
        assertEquals(8, solution.doAlgebra(List.of("/", "*"), List.of(7, 3, 4)));
    }
}
