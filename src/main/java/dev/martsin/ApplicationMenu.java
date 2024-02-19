package dev.martsin;

import dev.martsin.fourier.FourierCalculator;
import dev.martsin.writer.ConsoleWriteHelper;

import java.util.Scanner;

public class ApplicationMenu {
    private final PlotDrawer plotDrawer;
    private final ConsoleWriteHelper consoleWriteHelper;
    private final FourierCalculator calculator;

    public ApplicationMenu(PlotDrawer plotDrawer, ConsoleWriteHelper consoleWriteHelper, FourierCalculator calculator) {
        this.plotDrawer = plotDrawer;
        this.consoleWriteHelper = consoleWriteHelper;
        this.calculator = calculator;
    }

    public void start() {
        System.out.println("Welcome to Fourier series calculator!");
        System.out.println("Choose the option:");
        System.out.println("1. Calculate Fourier series and draw a plot");
        System.out.println("2. Calculate Fourier series and print it to console");
        System.out.println("3. Calculate average error");
        System.out.println("4. Exit");
        int option = new Scanner(System.in).nextInt();
        while (option != 4) {
            processOption(option);
            System.out.println("Choose the option:");
            System.out.println("1. Calculate Fourier series and draw a plot");
            System.out.println("2. Calculate Fourier series and print it to console");
            System.out.println("3. Calculate average error");
            System.out.println("4. Exit");
            option = new Scanner(System.in).nextInt();
        }

    }

    private void processOption(int option){
        switch (option) {
            case 1 -> {
                System.out.print("Enter N of Fourier series: ");
                int n = new Scanner(System.in).nextInt();
                System.out.println("Enter the interval [a,b]:");
                System.out.print("a = ");
                double a = new Scanner(System.in).nextDouble();
                System.out.print("b = ");
                double b = new Scanner(System.in).nextDouble();
                System.out.print("Enter the number of points: ");
                int nOfPoints = new Scanner(System.in).nextInt();
                plotDrawer.drawFourierPlot(a, b, MyFourierConfig.FUNCTION, calculator, nOfPoints, n);
            }
            case 2 -> {
                System.out.print("Enter N of Fourier series: ");
                int n = new Scanner(System.in).nextInt();
                System.out.print("Enter the point t: ");
                double t = new Scanner(System.in).nextDouble();
                consoleWriteHelper.printFourierSeries(MyFourierConfig.FUNCTION, MyFourierConfig.A,
                        MyFourierConfig.B, n, t);
            }
            case 3 -> {
                System.out.print("Enter N of Fourier series: ");
                int n = new Scanner(System.in).nextInt();
                System.out.println("Average error for [" +MyFourierConfig.A + " , " + MyFourierConfig.B +
                        "] interval with 100 points and " + "fourier series with " +
                        n + " members is: " +
                        calculator.countAverageError(MyFourierConfig.FUNCTION, MyFourierConfig.A,
                                MyFourierConfig.B, n, 100));
            }
            case 4 -> System.exit(0);
            default -> {
                System.out.println("Invalid option");
                start();
            }
        }
    }
}
