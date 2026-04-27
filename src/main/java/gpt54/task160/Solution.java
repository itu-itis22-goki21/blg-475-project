package gpt54.task160;

/* @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
*/

import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given two lists operator, and operand. The first list has basic algebra operations, and
    the second list is a list of integers. Use the two given lists to build the algebric
    expression and return the evaluation of this expression.

    The basic algebra operations:
    Addition ( + )
    Subtraction ( - )
    Multiplication ( * )
    Floor division ( / )
    Exponentiation ( ** )

    Example:
    operator["+", "*", "-"]
    array = [2, 3, 4, 5]
    result = 2 + 3 * 4 - 5
    => result = 9

    Note:
        The length of operator list is equal to the length of operand list minus one.
        Operand is a list of of non-negative integers.
        Operator list has at least one operator, and operand list has at least two operands.
     */
    public int doAlgebra(List<String> operator, List<Integer> operand) {
        if (operator == null || operand == null) {
            throw new IllegalArgumentException("operator and operand must not be null");
        }
        if (operator.isEmpty() || operand.size() < 2 || operator.size() != operand.size() - 1) {
            throw new IllegalArgumentException("operator and operand lengths are inconsistent");
        }

        Deque<Integer> values = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        values.push(operand.get(0));
        for (int i = 0; i < operator.size(); i++) {
            String current = operator.get(i);
            while (!operators.isEmpty() && shouldApplyBefore(operators.peek(), current)) {
                applyTop(values, operators.pop());
            }
            operators.push(current);
            values.push(operand.get(i + 1));
        }

        while (!operators.isEmpty()) {
            applyTop(values, operators.pop());
        }

        return values.pop();
    }

    private boolean shouldApplyBefore(String stacked, String current) {
        int stackedPrecedence = precedence(stacked);
        int currentPrecedence = precedence(current);
        if (stackedPrecedence > currentPrecedence) {
            return true;
        }
        return stackedPrecedence == currentPrecedence;
    }

    private int precedence(String operator) {
        if (operator.equals("**")) {
            return 3;
        }
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return 1;
    }

    private void applyTop(Deque<Integer> values, String operator) {
        int right = values.pop();
        int left = values.pop();
        int result;

        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = Math.floorDiv(left, right);
                break;
            case "**":
                result = intPow(left, right);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        values.push(result);
    }

    private int intPow(int base, int exponent) {
        int result = 1;
        int currentBase = base;
        int currentExponent = exponent;

        while (currentExponent > 0) {
            if ((currentExponent & 1) == 1) {
                result *= currentBase;
            }
            currentBase *= currentBase;
            currentExponent >>= 1;
        }

        return result;
    }
}

