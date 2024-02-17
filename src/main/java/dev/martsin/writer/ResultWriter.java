package dev.martsin.writer;

public interface ResultWriter {
    void writeNofFourierSeries(Integer n);
    void writeFourierSeries(Double t, Double value);
    void writeFunctionValue(Double t, Double value);
    void writeA0(Double a0);
    void writeAn(Integer n, Double an);
    void writeBn(Integer n, Double bn);
}
