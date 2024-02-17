package dev.martsin.fourier;

import dev.martsin.writer.ResultFileWriter;

import java.util.function.Function;



public class FourierCalculatorImpl implements FourierCalculator {
    private final ResultFileWriter resultFileWriter;
    private final IntegralCalculator integralCalculator;

    public FourierCalculatorImpl(String resultFileName, IntegralCalculator integralCalculator) {
        this.resultFileWriter = new ResultFileWriter(resultFileName);
        this.integralCalculator = integralCalculator;
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

    public Double countFourierSeries(Function<Double, Double> f, double a, double b, int n, double t) {
        resultFileWriter.writeNofFourierSeries(n);
        t = t % (2 * Math.PI);
        if(t < - Math.PI) t += 2 * Math.PI;
        if(t > Math.PI) t -= 2 * Math.PI;
        double sum = 0;
        var a0 = countA0(f, a, b);
        resultFileWriter.writeA0(a0);
        for (int i = 1; i <= n; i++) {
            var an = countAn(f, a, b, i);
            var bn = countBn(f, a, b, i);
            sum += an * Math.cos(i * t) + bn * Math.sin(i * t);
            resultFileWriter.writeAn(i, an);
            resultFileWriter.writeBn(i, bn);
        }
        var fourier = a0 / 2 + sum;
        resultFileWriter.writeFunctionValue(t, f.apply(t));
        resultFileWriter.writeFourierSeries(t, fourier);
        return fourier;
    }

    public Double countAverageError(Function<Double, Double> f, double a, double b, int fourierN, int nOfPoints) {
        double h = (b - a) / nOfPoints;
        double sum = 0;
        for (int i = 0; i < nOfPoints; i++) {
            double t = a + i * h;
            sum += Math.abs(f.apply(t) - countFourierSeries(f, a, b, fourierN, t));
        }
        return sum / nOfPoints;
    }
}
