package dev.martsin.fourier;

import java.util.function.Function;

public interface FourierCalculator {
    Double countFourierSeries(Function<Double, Double> f, double a, double b, int n, double t);
    Double countAverageError(Function<Double, Double> f, double a, double b, int fourierN, int nOfPoints);
}
