package dev.martsin;

import java.util.HashMap;
import java.util.Map;

public class MyFourierConfig {

    //2,81; 2,95; 3,21; 3,39; 3,54; 3,76

    public static final Map<Double, Double> FUNCTION = new HashMap<>(){
        {
            put(-Math.PI + 1 * ((2 * Math.PI) / 6), 2.81);
            put(-Math.PI + 2 * ((2 * Math.PI) / 6), 2.95);
            put(-Math.PI + 3 * ((2 * Math.PI) / 6), 3.21);
            put(-Math.PI + 4 * ((2 * Math.PI) / 6), 3.39);
            put(-Math.PI + 5 * ((2 * Math.PI) / 6), 3.54);
            put(-Math.PI + 6 * ((2 * Math.PI) / 6), 3.76);
        }
    };
    public static final double A = -Math.PI;
    public static final double B = Math.PI;
}
