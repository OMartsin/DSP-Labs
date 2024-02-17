package dev.martsin;

import dev.martsin.fourier.FourierCalculator;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.util.function.Function;

public class PlotDrawer {
    public void drawFourierPlot(double a, double b, Function<Double,Double> f,
                                FourierCalculator calculator, int nOfPoints, int fourierN) {
        double[] x = new double[nOfPoints];
        double[] y = new double[nOfPoints];
        double[] yF = new double[nOfPoints];
        double h = (b - a) / nOfPoints;
        for (int i = 0; i < nOfPoints; i++) {
            x[i] = a + i * h;
            y[i] = f.apply(x[i]);
            yF[i] = calculator.countFourierSeries(f, MyFourierConfig.A, MyFourierConfig.B, fourierN, x[i]);
        }
        XYChartInit(x, y, yF);
    }

    private void XYChartInit(double[] x, double[] y, double[] yF) {
        XYChart chart = new XYChartBuilder().width(800).height(600).
                title("Fourier series").xAxisTitle("t").yAxisTitle("FUNCTION(t)").build();
        var fSeries = chart.addSeries("FUNCTION(t)", x, y);
        fSeries.setLineColor(Color.BLUE);
        fSeries.setLineStyle(SeriesLines.SOLID);
        fSeries.setMarker(SeriesMarkers.NONE);
        var seriesFourier = chart.addSeries("Fourier Series", x, yF);
        seriesFourier.setLineColor(Color.RED);
        seriesFourier.setLineStyle(SeriesLines.SOLID);
        seriesFourier.setMarker(SeriesMarkers.NONE);
        chart.getStyler().setDefaultSeriesRenderStyle(org.knowm.xchart.XYSeries.XYSeriesRenderStyle.Line);
        new SwingWrapper(chart).displayChart();
    }
}
