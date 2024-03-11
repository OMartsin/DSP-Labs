package dev.martsin.fourier;

import java.util.HashMap;
import java.util.Map;

public class FourierCalculatorDiscrete implements FourierCalculator {
    private final Map<Double, Double> discreteFunction;
    private final Map<Integer, Double> ak;
    private final Map<Integer, Double> bk;

    public FourierCalculatorDiscrete(
                                 Map<Double, Double> discreteFunction) {
        this.discreteFunction = discreteFunction;
        this.ak = new HashMap<>();
        this.bk = new HashMap<>();
    }

    public Double countFourierSeries(int n, double t) {
        Double a0 = ak.computeIfAbsent(0, k -> countA0());
        double sum = a0 / 2;
        for (int k = 1; k < n; k++) {
            var ak = this.ak.computeIfAbsent(k, this::countAk);
            var bk = this.bk.computeIfAbsent(k, this::countBk);
            sum += ak * Math.cos(k * t) + bk * Math.sin(k * t);
        }
        return sum;
    }

    private Double countA0() {
        var ak = 0.0;
        for(var entry: discreteFunction.entrySet()){
            ak += entry.getValue();
        }
        return ak * (2.0 / discreteFunction.size());
    }

    private Double countAk(int k) {
        var ak = 0.0;
        for(var entry: discreteFunction.entrySet()){
            ak += entry.getValue() * Math.cos(k * entry.getKey());
        }
        return ak * (2.0 / discreteFunction.size());
    }

    private Double countBk(int k) {
        var bk = 0.0;
        for(var entry: discreteFunction.entrySet()){
            bk += entry.getValue() * Math.sin(k * entry.getKey());
        }
        return bk * (2.0 / discreteFunction.size());
    }
}