package dev.martsin;

import java.util.HashMap;
import java.util.Map;

public class MyFourierConfig {

    public static final Map<Double, Double> FUNCTION = new HashMap<>(){
        {
            put(-Math.PI + 1 * ((2 * Math.PI) / 6), 4.42);
            put(-Math.PI + 2 * ((2 * Math.PI) / 6), 5.41);
            put(-Math.PI + 3 * ((2 * Math.PI) / 6), 5.09);
            put(-Math.PI + 4 * ((2 * Math.PI) / 6), 7.33);
            put(-Math.PI + 5 * ((2 * Math.PI) / 6), 8.05);
            put(-Math.PI + 6 * ((2 * Math.PI) / 6), 9.87);
        }
    };
    public static final double A = -Math.PI;
    public static final double B = Math.PI;
}
