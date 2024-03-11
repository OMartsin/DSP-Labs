package dev.martsin;

import dev.martsin.fourier.FourierCalculator;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.util.Map;
import java.util.function.Function;

public class PlotDrawer {
    public void drawFourierPlot(double a, double b, Map<Double, Double> function,
                                FourierCalculator calculator, int nOfPoints, Function<Double, Double> polynom) {
        double[] x = new double[function.size()];
        double[] y = new double[function.size()];
        double[] xF = new double[nOfPoints];
        double[] yF = new double[nOfPoints];
        double[] xP = new double[nOfPoints];
        double[] yP = new double[nOfPoints];
        double h = (b - a) / nOfPoints;
        int i = 0;
        for(var entry: function.entrySet()){
            x[i] = entry.getKey();
            y[i] = entry.getValue();
            i++;
        }
        for (i = 0; i < nOfPoints; i++) {
            xF[i] = a + i * h;
            yF[i] = calculator.countFourierSeries(MyFourierConfig.FOURIER_N, xF[i]);
            xP[i] = a + i * h;
            yP[i] = polynom.apply(xP[i]);
        }
        XYChartInit(x, y, xF, yF, xP, yP);
    }

    private void XYChartInit(double[] x, double[] y, double[] xF, double[] yF, double[] xP, double[] yP) {
        XYChart chart = new XYChartBuilder().width(800).height(600).
                title("Fourier series").xAxisTitle("t").yAxisTitle("FUNCTION(t)").build();
        var fSeries = chart.addSeries("FUNCTION(t)", x, y);
        fSeries.setMarker(SeriesMarkers.CIRCLE);
        fSeries.setLineColor(Color.BLUE);
        fSeries.setLineStyle(SeriesLines.NONE);
        var seriesFourier = chart.addSeries("Fourier Series", xF, yF);
        seriesFourier.setLineColor(Color.RED);
        seriesFourier.setLineStyle(SeriesLines.SOLID);
        seriesFourier.setMarker(SeriesMarkers.NONE);
        var seriesPolynom = chart.addSeries("Polynomial", xP, yP);
        seriesPolynom.setLineColor(Color.GREEN);
        seriesPolynom.setLineStyle(SeriesLines.SOLID);
        seriesPolynom.setMarker(SeriesMarkers.NONE);
        new SwingWrapper(chart).displayChart();
    }
}
