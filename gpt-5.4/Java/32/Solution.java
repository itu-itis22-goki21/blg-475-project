import java.util.*;
import java.lang.*;

class Solution {
    /**
    Evaluates polynomial with coefficients xs at point x.
    return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
     */
    public double poly(List<Double> xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }
    
    /**
    xs are coefficients of a polynomial.
    findZero find x such that poly(x) = 0.
    findZero returns only only zero point, even if there are many.
    Moreover, findZero only takes list xs having even number of coefficients
    and largest non zero coefficient as it guarantees
    a solution.
    >>> findZero(Arrays.asList(1, 2)) // f(x) = 1 + 2x
    -0.5
    >>> findZero(Arrays.asList(-6, 11, -6, 1)) // (x - 1) * (x - 2) * (x - 3) = -6 + 11x - 6x^2 + x^3
    1.0
     */
    public double findZero(List<Double> xs) {
        double left = -1.0;
        double right = 1.0;
        double leftValue = poly(xs, left);
        double rightValue = poly(xs, right);

        while (leftValue * rightValue > 0) {
            left *= 2.0;
            right *= 2.0;
            leftValue = poly(xs, left);
            rightValue = poly(xs, right);
        }

        for (int i = 0; i < 200; i++) {
            double mid = (left + right) / 2.0;
            double midValue = poly(xs, mid);

            if (Math.abs(midValue) < 1e-12) {
                return mid;
            }

            if (leftValue * midValue <= 0) {
                right = mid;
                rightValue = midValue;
            } else {
                left = mid;
                leftValue = midValue;
            }
        }

        return (left + right) / 2.0;
    }
}
