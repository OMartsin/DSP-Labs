package dev.martsin.writer;

import dev.martsin.fourier.FourierCalculator;

import java.util.function.Function;

public class ConsoleWriteHelper {
    private final FourierCalculator fourierCalculator;

    public ConsoleWriteHelper(FourierCalculator fourierCalculatorImpl) {
        this.fourierCalculator = fourierCalculatorImpl;
    }
    public void printFourierSeries(Function<Double, Double> f, double a, double b, int n, double t) {
        System.out.println("FUNCTION(t) = ");
        System.out.println(f.apply(t));
        System.out.println("Fourier series for f(t) = " +
                " on interval [" + a + ", " + b + "] with N=" + n + " members at t = " + t + " is: ");
        System.out.println(fourierCalculator.countFourierSeries(f, a, b, n, t));
    }
}
