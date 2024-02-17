package dev.martsin.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ResultFileWriter implements ResultWriter {
    private final String fileName;

    public ResultFileWriter(String fileName) {
        this.fileName = fileName;
    }
    public void writeNofFourierSeries(Integer n) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("N of Fourier series: " + n);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFourierSeries(Double t, Double value) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("Fourier series value at t = " + t + " is " + value);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFunctionValue(Double t, Double value) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("Function value at t = " + t + " is " + value);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeA0(Double a0) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("A0 = " + a0);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeAn(Integer n, Double an) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("A(" + n + ") = " + an);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeBn(Integer n, Double bn) {
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("B(" + n + ") = " + bn);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

