package dev.martsin;

import dev.martsin.fourier.FourierCalculatorFunction;
import dev.martsin.fourier.SimpsonIntegralCalculator;
import dev.martsin.polinom.PolynomCalculator;

public class Main {
    public static void main(String[] args) {
        var plotDrawer = new PlotDrawer();
        var nOfPoints = 1000;
        var polynomCalculator = new PolynomCalculator();
        var functionFourierCalculator = new FourierCalculatorFunction(new SimpsonIntegralCalculator(), polynomCalculator.
                calculatePolynomialFunction(MyFourierConfig.FUNCTION));
        plotDrawer.drawFourierPlot(MyFourierConfig.A, MyFourierConfig.B
                , MyFourierConfig.FUNCTION, functionFourierCalculator, nOfPoints, polynomCalculator.
                        calculatePolynomialFunction(MyFourierConfig.FUNCTION));
        AvgErrorCalculator avgErrorCalculator = new AvgErrorCalculator();
        polynomCalculator.printPolynomialFunction(MyFourierConfig.FUNCTION);
        avgErrorCalculator.calculateAvgPolynomError(MyFourierConfig.FUNCTION);
        avgErrorCalculator.calculateAvgFourierError(MyFourierConfig.FUNCTION);
//        avgErrorCalculator.calculateAvgQuadraticPolynomError(MyFourierConfig.FUNCTION);
//        avgErrorCalculator.calculateAvgQuadraticFourierError(MyFourierConfig.FUNCTION);
    }
}