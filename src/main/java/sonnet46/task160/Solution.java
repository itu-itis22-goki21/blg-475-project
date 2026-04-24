package sonnet46.task160;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given two lists operator, and operand. The first list has basic algebra operations, and
     * the second list is a list of integers. Use the two given lists to build the algebraic
     * expression and return the evaluation of this expression.
     *
     * The basic algebra operations: Addition(+), Subtraction(-), Multiplication(*),
     * Floor division(/), Exponentiation(**)
     *
     * Example:
     * operator["+", "*", "-"]
     * array = [2, 3, 4, 5]
     * result = 2 + 3 * 4 - 5 => 9
     */
    public int doAlgebra(List<String> operator, List<Integer> operand) {
        List<String> ops = new ArrayList<>(operator);
        List<Integer> nums = new ArrayList<>(operand);

        // Handle exponentiation right-to-left
        for (int i = ops.size() - 1; i >= 0; i--) {
            if (ops.get(i).equals("**")) {
                int val = (int) Math.pow(nums.get(i), nums.get(i + 1));
                nums.set(i, val);
                nums.remove(i + 1);
                ops.remove(i);
            }
        }

        // Handle multiplication and division left-to-right
        int i = 0;
        while (i < ops.size()) {
            if (ops.get(i).equals("*") || ops.get(i).equals("/")) {
                int val = ops.get(i).equals("*")
                        ? nums.get(i) * nums.get(i + 1)
                        : nums.get(i) / nums.get(i + 1);
                nums.set(i, val);
                nums.remove(i + 1);
                ops.remove(i);
            } else {
                i++;
            }
        }

        // Handle addition and subtraction left-to-right
        i = 0;
        while (i < ops.size()) {
            if (ops.get(i).equals("+") || ops.get(i).equals("-")) {
                int val = ops.get(i).equals("+")
                        ? nums.get(i) + nums.get(i + 1)
                        : nums.get(i) - nums.get(i + 1);
                nums.set(i, val);
                nums.remove(i + 1);
                ops.remove(i);
            } else {
                i++;
            }
        }

        return nums.get(0);
    }
}
