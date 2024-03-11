package dev.martsin;

import dev.martsin.fourier.FourierCalculator;
import dev.martsin.fourier.FourierCalculatorFunction;
import dev.martsin.fourier.SimpsonIntegralCalculator;
import dev.martsin.polinom.PolynomCalculator;

import java.util.Map;
import java.util.function.Function;

public class AvgErrorCalculator {
    public void calculateAvgQuadraticPolynomError(Map<Double,Double> discreteFunction) {
        PolynomCalculator polynomCalculator = new PolynomCalculator();
        Function<Double, Double> polynomFunction = polynomCalculator.calculatePolynomialFunction(discreteFunction);
        System.out.println("Avg quadratic error polynom: " + calculateAvgQuadraticError(discreteFunction, polynomFunction));
    }

    public void calculateAvgQuadraticFourierError(Map<Double,Double> discreteFunction) {
        FourierCalculator fourierCalculator = new FourierCalculatorFunction(new SimpsonIntegralCalculator(),
                new PolynomCalculator().calculatePolynomialFunction(discreteFunction));
        System.out.println("Avg quadratic error fourier: " + calculateAvgQuadraticError(discreteFunction,
                fourierCalculator));
    }

    public void calculateAvgPolynomError(Map<Double, Double> discreteFunction) {
        PolynomCalculator polynomCalculator = new PolynomCalculator();
        Function<Double, Double> polynomFunction = polynomCalculator.calculatePolynomialFunction(discreteFunction);
        System.out.println("Avg error polynom: " + calculateAvgError(discreteFunction, polynomFunction));
    }

    public void calculateAvgFourierError(Map<Double, Double> discreteFunction) {
        FourierCalculator fourierCalculator = new FourierCalculatorFunction(new SimpsonIntegralCalculator(),
                new PolynomCalculator().calculatePolynomialFunction(discreteFunction));
        System.out.println("Avg error fourier: " + calculateAvgError(discreteFunction, fourierCalculator));
    }

    private double calculateAvgQuadraticError(Map<Double, Double> discreteFunction, Function<Double, Double> polynomFunction) {
        double sumPolynom = 0;
        double sumFunction = 0;
        for (Map.Entry<Double, Double> entry : discreteFunction.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            sumPolynom += Math.pow(polynomFunction.apply(x), 2);
            sumFunction += Math.pow(y, 2);
        }
        return Math.sqrt(Math.abs(sumPolynom - sumFunction) / discreteFunction.size());
    }

    private double calculateAvgQuadraticError(Map<Double, Double> discreteFunction, FourierCalculator fourierCalculator) {
        double sumPolynom = 0;
        double sumFunction = 0;
        for (Map.Entry<Double, Double> entry : discreteFunction.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            sumPolynom += Math.pow(fourierCalculator.countFourierSeries(MyFourierConfig.FOURIER_N,x), 2);
            sumFunction += Math.pow(y, 2);
        }
        return Math.sqrt(Math.abs(sumPolynom - sumFunction) / discreteFunction.size());
    }

    private double calculateAvgError(Map<Double, Double> discreteFunction, Function<Double, Double> polynomFunction) {
        double sum = 0;
        for (Map.Entry<Double, Double> entry : discreteFunction.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            sum += Math.abs(polynomFunction.apply(x) - y);
        }
        return sum / discreteFunction.size();
    }

    private double calculateAvgError(Map<Double, Double> discreteFunction, FourierCalculator fourierCalculator) {
        double sum = 0;
        for (Map.Entry<Double, Double> entry : discreteFunction.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            sum += Math.abs(fourierCalculator.countFourierSeries(MyFourierConfig.FOURIER_N,x) - y);
        }
        return sum / discreteFunction.size();
    }
}
