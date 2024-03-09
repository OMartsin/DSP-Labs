package dev.martsin;

import dev.martsin.fourier.FourierCalculatorImpl;
import dev.martsin.polinom.PolynomCalculator;

public class Main {
    public static void main(String[] args) {
        var plotDrawer = new PlotDrawer();
        var fourierCalculator = new FourierCalculatorImpl(MyFourierConfig.FUNCTION);
        var nOfPoints = 1000;
        var polynomCalculator = new PolynomCalculator();
        plotDrawer.drawFourierPlot(MyFourierConfig.A, MyFourierConfig.B
                , MyFourierConfig.FUNCTION, fourierCalculator, nOfPoints, polynomCalculator.
                        calculatePolynomialFunction(MyFourierConfig.FUNCTION));
        AvgErrorCalculator avgErrorCalculator = new AvgErrorCalculator();
        avgErrorCalculator.calculateAvgPolynomError(MyFourierConfig.FUNCTION);
        avgErrorCalculator.calculateAvgFourierError(MyFourierConfig.FUNCTION);
        avgErrorCalculator.calculateAvgQuadraticPolynomError(MyFourierConfig.FUNCTION);
        avgErrorCalculator.calculateAvgQuadraticFourierError(MyFourierConfig.FUNCTION);
    }
}