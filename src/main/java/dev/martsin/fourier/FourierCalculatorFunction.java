package dev.martsin.fourier;

import java.util.function.Function;

public class FourierCalculatorFunction implements FourierCalculator {
    private final IntegralCalculator integralCalculator;
    private final Function<Double,Double> f;

    public FourierCalculatorFunction(IntegralCalculator integralCalculator, Function<Double,Double> f) {
        this.integralCalculator = integralCalculator;
        this.f = f;
    }
    private Double countAn(Function<Double, Double> f, double a, double b, int n) {
        return (1 / Math.PI) * integralCalculator.calculateIntegral(t -> f.apply(t) * Math.cos(n * t), a, b);
    }

    private Double countBn(Function<Double, Double> f, double a, double b, int n) {
        return (1 / Math.PI) * integralCalculator.calculateIntegral(t -> f.apply(t) * Math.sin(n * t), a, b);
    }

    public Double countA0(Function<Double, Double> f, double a, double b) {
        return (1 / Math.PI) * integralCalculator.calculateIntegral(f, a, b);
    }

    public Double countFourierSeries(int n, double t) {
        t = t % (2 * Math.PI);
        var a = -Math.PI;
        var b = Math.PI;
        if(t < - Math.PI) t += 2 * Math.PI;
        if(t > Math.PI) t -= 2 * Math.PI;
        double sum = 0;
        var a0 = countA0(f, a, b);
        for (int i = 1; i <= n; i++) {
            var an = countAn(f, a, b, i);
            var bn = countBn(f, a, b, i);
            sum += an * Math.cos(i * t) + bn * Math.sin(i * t);
        }
        return a0 / 2 + sum;
    }
}