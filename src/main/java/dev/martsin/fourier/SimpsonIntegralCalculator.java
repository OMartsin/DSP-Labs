package dev.martsin.fourier;

import dev.martsin.MyFourierConfig;

import java.util.function.Function;

public class SimpsonIntegralCalculator implements IntegralCalculator{
    private final static double n = 1000;

    public Double calculateIntegral(Function<Double, Double> f, Double a, Double b) {
        double h = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < MyFourierConfig.SIMPSON_N; i++) {
            sum += f.apply(a + i * h) * h;
        }
        return sum;
    }
}
