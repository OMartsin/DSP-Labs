package dev.martsin;

import dev.martsin.fourier.FourierCalculatorImpl;
import dev.martsin.fourier.SimpsonIntegralCalculator;
import dev.martsin.writer.ConsoleWriteHelper;

public class Main {
    public static void main(String[] args) {
        var plotDrawer = new PlotDrawer();
        var IntegralCalculator = new SimpsonIntegralCalculator();
        var filePath = "src/main/resources/log.txt";
        var fourierCalculator = new FourierCalculatorImpl(filePath, IntegralCalculator);
        var consoleWriter = new ConsoleWriteHelper(fourierCalculator);
        ApplicationMenu applicationMenu = new ApplicationMenu(plotDrawer, consoleWriter, fourierCalculator);
        applicationMenu.start();
    }
}