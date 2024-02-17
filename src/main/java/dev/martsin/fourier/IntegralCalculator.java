package dev.martsin.fourier;

import java.util.function.Function;

public interface IntegralCalculator {
    Double calculateIntegral(Function<Double, Double> f, Double a, Double b);
}
