package dev.martsin.polinom;

import java.util.Map;
import java.util.function.Function;

public class PolynomCalculator {
    public Function<Double, Double> calculatePolynomialFunction(Map<Double, Double> points) {
        double[] coefficients = solveForPolynomialCoefficients(points);
        return x -> coefficients[0] * x * x + coefficients[1] * x + coefficients[2];
    }

    public void printPolynomialFunction(Map<Double, Double> points) {
        double[] coefficients = solveForPolynomialCoefficients(points);
        System.out.println("Polynomial function: " + coefficients[0] + "x^2 + " + coefficients[1] + "x + " + coefficients[2]);
    }

    private double[] solveForPolynomialCoefficients(Map<Double, Double> points) {
        double[][] sys = new double[3][4];
        for (Map.Entry<Double, Double> entry : points.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            sys[0][0] += x * x * x * x;
            sys[0][1] += x * x * x;
            sys[0][2] += x * x;
            sys[1][0] += x * x * x;
            sys[1][1] += x * x;
            sys[1][2] += x;
            sys[2][0] += x * x;
            sys[2][1] += x;
            sys[2][2] += 1;
            sys[0][3] += y * x * x;
            sys[1][3] += y * x;
            sys[2][3] += y;
        }
        double[] res = new double[3];
        gaussJordan(sys, res);
        return res;
    }

    private void gaussJordan(double[][] sys, double[] res) {
        int n = 3;
        for (int i = 0; i < n; i++) {
            double div = sys[i][i];
            for (int j = 0; j <= n; j++) {
                sys[i][j] /= div;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = sys[k][i];
                    for (int j = 0; j <= n; j++) {
                        sys[k][j] -= factor * sys[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = sys[i][n];
        }
    }
}
